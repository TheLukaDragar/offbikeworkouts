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

package com.dragar.luka.offbikeworkouts.presenter

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.os.Parcelable
import com.dragar.luka.offbikeworkouts.R

import com.dragar.luka.offbikeworkouts.WorkoutContract2
import com.dragar.luka.offbikeworkouts.model.Workout2
import com.dragar.luka.offbikeworkouts.view.WorkoutActivity2
import com.dragar.luka.offbikeworkouts.view.WorkoutChime2
import com.dragar.luka.offbikeworkouts.view.WorkoutNotification2
import com.dragar.luka.offbikeworkouts.view.WorkoutTTS2
import java.lang.ref.WeakReference

/**
@author Miroslav Mazel
 */

//todo

//todo render state along with countdown immediately (esp. when going through exercises)
class WorkoutService2 : Service(), WorkoutContract2.Presenter {
    var disconnectOnUnbind = false

    private var connectionID: Int? = null
    private var presenter: WorkoutPresenter2? = null
    private var audioView: WorkoutContract2.View? = null
    private var notificationView: WorkoutContract2.View? = null

    inner class WorkoutBinder : Binder() {
        val service: WeakReference<WorkoutService2>
            get() = WeakReference(this@WorkoutService2)
    }

    //todo check that workout.size > 0 before starting workout, otherwise show empty state

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            WorkoutNotification2.createNotificationChannel(getSystemService(NotificationManager::class.java),
                    getString(R.string.workout_notification_title),
                    getString(R.string.workout_notification_description))
    }

    override fun onDestroy() {
        presenter?.close()
        audioView?.close()
        notificationView?.close()
        super.onDestroy()
    }

    override fun setHostView(callback: WorkoutContract2.View, savedState: Parcelable?, workout: Workout2, ttsEnabled: Boolean) { //todo restore view state here!! //todo figure out how to deal with audio in general -- no effect when restoring service here
        if (presenter == null) {
            if (audioView != null)
                throw IllegalStateException("audio view can't be null when presenter is null")
            if (notificationView != null)
                throw IllegalStateException("notification view can't be null when presenter is null")

            audioView =
                    if (ttsEnabled) WorkoutTTS2(WeakReference(this))
                    else WorkoutChime2(WeakReference(this))

            presenter =
                    if (savedState != null) WorkoutPresenter2(savedState, WeakReference(audioView!!), WeakReference(callback))
                    else WorkoutPresenter2(workout, WeakReference(audioView!!), WeakReference(callback))
        } else {
            presenter?.addViews(WeakReference(callback))
        }
    }

    override fun saveState(): Parcelable? {
        return presenter?.getSavedState()
    }

    override fun disconnect(view: WorkoutContract2.View) {
        presenter?.removeView(view)
    }

    //
    // View toggles
    //

    override fun skipToPreviousExercise() {
        presenter?.skipToPreviousExercise()
    }

    override fun skipToNextExercise() {
        presenter?.skipToNextExercise()
    }

    override fun togglePlayPause() {
        presenter?.togglePlayPause()
    }

    override fun forceRender(view: WorkoutContract2.View) {
        presenter?.renderToView(view)
    }

    //
    // Lifecycle
    //

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        connectionID?.let { stopSelf(it) }
        connectionID = startId
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder {
        stopNotification()
        return WorkoutBinder()
    }

    override fun onRebind(intent: Intent?) {
        stopNotification()
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        if (shouldRunInBackground()) //todo fix: seem to not be getting rid of old notifications!
            buildNotification()
        else
            stopStartedService()

        return true
    }

    private fun shouldRunInBackground(): Boolean {
        return presenter?.isPlaying() == true && !disconnectOnUnbind
    }

    private fun buildNotification() {
        val activityIntent = PendingIntent.getActivity(
                this,
                0,
                Intent(this, WorkoutActivity2::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notificationView = WorkoutNotification2(this, activityIntent)

        presenter?.addViews(WeakReference(notificationView)) //todo remove view after
        this.notificationView = notificationView
    }

    private fun stopStartedService() { //todo stop self after completion?
        stopNotification()
        connectionID?.let { stopSelf(it) }
        connectionID = null
    }

    private fun stopNotification() {
        stopForeground(true)
        notificationView?.let { presenter?.removeView(it) }
        notificationView = null
    }

//    private fun enableAudio() { //todo is this needed? could pass audio in constructor //todo should pass both views at once, to avoid empty rerendering
//        if (audioView == null) {
//            audioView = WorkoutTTS(WeakReference(this))
//            presenter?.addViews(audioView!!)
//        }
//    }
//
//    private fun disableAudio() {
//        if (audioView != null) {
//            presenter?.removeView(audioView!!)
//            audioView?.close()
//            audioView = null
//        }
//    }
}