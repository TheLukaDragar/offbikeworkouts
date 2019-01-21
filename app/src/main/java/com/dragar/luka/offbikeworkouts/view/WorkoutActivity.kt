/*
 * This file is part of Feeel.
 *
 *     Feeel is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Feeel is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Feeel.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.dragar.luka.offbikeworkouts.view

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.media.AudioManager
import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import com.dragar.luka.offbikeworkouts.R
import com.dragar.luka.offbikeworkouts.WorkoutContract
import com.dragar.luka.offbikeworkouts.model.ExerciseMeta
import com.dragar.luka.offbikeworkouts.model.Workout
import com.dragar.luka.offbikeworkouts.presenter.WorkoutService
import com.dragar.luka.offbikeworkouts.view.WorkoutPagerAdapter.Companion.SUCCESS_INDEX_FROM_END
import com.dragar.luka.offbikeworkouts.view.WorkoutPagerAdapter.Companion.WORKOUT_INDEX_FIRST
import kotlinx.android.synthetic.main.activity_workout.*
import java.lang.ref.WeakReference


//todo license info
//todo separate activity without workout
//todo force media playback audio controls at all times on this activity
//todo use a pager, preload next exercises
//todo make sure that an empty description still covers the whole width


//TODO add view stuff from contract

class WorkoutActivity : AppCompatActivity(), ServiceConnection, WorkoutContract.View {
    companion object {
        const val TTS_KEY = "audio"
        const val WORKOUT_KEY = "workout"

        private const val STATE_KEY = "STATE"
    }

    private inner class PausePlayListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            this@WorkoutActivity.presenterService?.get()?.togglePlayPause()
        }
    }

    //todo implement transition based on https://www.thedroidsonroids.com/blog/android/meaningful-motion-with-shared-element-transition-and-circular-reveal-animation/ or https://guides.codepath.com/android/Circular-Reveal-Animation

    //todo do a pager view, preload
    internal var pausePlayListener: View.OnClickListener = PausePlayListener()
    internal var needsRerender = false
    private var presenterService: WeakReference<WorkoutService>? = null
    private var restoredState: Parcelable? = null
    private var ttsEnabled = false
    private var workout: Workout? = null

    //
    // Lifecycle
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        //todo fails when running in background, but activity card swiped away

        volumeControlStream = AudioManager.STREAM_MUSIC

        ttsEnabled = intent.getBooleanExtra(TTS_KEY, false)
        workout = intent.getParcelableExtra(WORKOUT_KEY)
//        workout?.customColor?.toInt()?.let { headerBox.setBackgroundColor(it) } //todo make sure color is applied on restore as well

        if (savedInstanceState != null) {
            restoredState = savedInstanceState.get(STATE_KEY) as Parcelable?
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    override fun onStart() {
        super.onStart()

        bindService(
                Intent(this, WorkoutService::class.java),
                this, Context.BIND_AUTO_CREATE
        )
    }

    override fun onStop() {
        super.onStop()
        startService(Intent(this, WorkoutService::class.java)) //todo perhaps not at all necessary
        presenterService?.get()?.disconnect(this)
        unbindService(this)
    }

    override fun onBackPressed() {
        presenterService?.get()?.disconnectOnUnbind = true
        super.onBackPressed()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        restoredState = presenterService?.get()?.saveState()
        outState.putParcelable(STATE_KEY, restoredState)
    }

    //
    // Service connection
    //

    override fun onServiceDisconnected(p0: ComponentName?) {
        presenterService = null
        //todo unset onclicklisteners needed?
    }

    override fun onServiceConnected(p0: ComponentName?, binder: IBinder) {
        presenterService = (binder as WorkoutService.WorkoutBinder).service
        presenterService?.let {
            workoutPagerOSVP.adapter = WorkoutPagerAdapter(supportFragmentManager, workout!!) //todo get workout from binder, not from activity, maybe (though I use the workout here to start the service, so maybe not? but the service may have a different workout)

            it.get()?.setHostView(callback = this, savedState = restoredState, workout = workout!!, ttsEnabled = ttsEnabled)

            //todo force rerender after first workout is loaded
            setOnClickListeners(it.get())
        }
    }

    fun forceRender() {
        presenterService?.get()?.forceRender(this)
    }


    private fun setOnClickListeners(service: WorkoutService?) {
        runOnUiThread {
            headerBoxV.setOnClickListener {
                //todo see if this covers the overlaid text as well —— I don't think it does, but it should
                service?.togglePlayPause()
            }

            playPauseIB.setOnClickListener {
                service?.togglePlayPause()
            }

            previousIB.setOnClickListener {
                service?.skipToPreviousExercise()
            }

            nextIB.setOnClickListener {
                //todo enable swiping through pages to get to next and prev. exercise, too, though only in this mode
                service?.skipToNextExercise()
            }

            upIB.setOnClickListener {
                onBackPressed()
            }
        }
    }

    private val curWorkoutFragment: WorkoutFragment?
        get() { //todo too inefficient
            val curFragment = (workoutPagerOSVP.adapter as WorkoutPagerAdapter)
                    .getFragment(workoutPagerOSVP.currentItem) as WorkoutFragment?
            if (curFragment == null) {
                needsRerender = true
            }

            return curFragment
        }

    override fun setExercise(workoutPos: Int, exerciseMeta: ExerciseMeta) {
        runOnUiThread {
            workoutPagerOSVP.setCurrentItem(WORKOUT_INDEX_FIRST + workoutPos, true)
            curWorkoutFragment?.setExercise()
        }
    }

    override fun setBreak(workoutPos: Int, nextExerciseMeta: ExerciseMeta, breakLength: Int) {
        runOnUiThread {
            workoutPagerOSVP.setCurrentItem(WORKOUT_INDEX_FIRST + workoutPos, true)
            curWorkoutFragment?.setBreak()
        }
    }

    override fun showFinish() {
        hideHeader()
        runOnUiThread {
            val successIndex = workoutPagerOSVP.adapter?.count ?: 0-SUCCESS_INDEX_FROM_END
            workoutPagerOSVP.setCurrentItem(successIndex, true)
        }
    }

    private fun hideHeader() {
        runOnUiThread {
            headerBoxV.visibility = View.GONE
            tapIndicatorTV.visibility = View.GONE
            timeTV.visibility = View.GONE
        }
        hideControls()
    }

    override fun setSeconds(seconds: Int) {
        runOnUiThread {
            timeTV.text = seconds.toString()
        }
    }

    override fun setPaused() {
        showControls()

        runOnUiThread {
            tapIndicatorTV.visibility = View.GONE
            timeTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimensionPixelSize(R.dimen.time_headline_small).toFloat())

            curWorkoutFragment?.setPaused()
        }
    }

    override fun setPlaying() {
        hideControls()

        runOnUiThread {
            tapIndicatorTV.visibility = View.VISIBLE
            timeTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.time_headline))
            curWorkoutFragment?.setPlaying()
        }
    }

    override fun close() {
        throw IllegalStateException("Can't close a WorkoutContract.View that's an Activity, as it has its own lifecycle")
    }

    private fun showControls() {
        runOnUiThread {
            playPauseIB.visibility = View.VISIBLE
            previousIB.visibility = View.VISIBLE
            nextIB.visibility = View.VISIBLE
            upIB.visibility = View.VISIBLE
        }
    }

    private fun hideControls() {
        runOnUiThread {
            playPauseIB.visibility = View.GONE
            previousIB.visibility = View.GONE
            nextIB.visibility = View.GONE
            upIB.visibility = View.GONE
        }
    }
}
