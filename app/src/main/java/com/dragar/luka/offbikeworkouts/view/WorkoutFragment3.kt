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

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.content.res.AppCompatResources
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dragar.luka.offbikeworkouts.R
import com.dragar.luka.offbikeworkouts.model.ExerciseMeta3
import kotlinx.android.synthetic.main.fragment_workout3.*

class WorkoutFragment3 internal constructor() : Fragment() {

    companion object {
        private const val EXERCISE_META = "exm"
        private const val BREAK_LENGTH = "brl"

        fun newInstance(exerciseMeta: ExerciseMeta3, breakLength: Int): WorkoutFragment3 {
            val fragment = WorkoutFragment3()
            val bundle = Bundle()
            bundle.putParcelable(EXERCISE_META, exerciseMeta)
            bundle.putInt(BREAK_LENGTH, breakLength)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val grayscaleMatrix = ColorMatrix()
    private val grayscaleFilter: ColorMatrixColorFilter

    private var exerciseMeta: ExerciseMeta3? = null
    private var breakLength = 0
    private var viewCreated = false

    init {
        grayscaleMatrix.setSaturation(0f)
        grayscaleFilter = ColorMatrixColorFilter(grayscaleMatrix)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exerciseMeta = arguments?.getParcelable(EXERCISE_META)
        breakLength = arguments?.getInt(BREAK_LENGTH) ?: -1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_workout3, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewCreated = true

        activity?.runOnUiThread {
            exerciseMeta?.let { exerciseMeta ->
                exerciseMeta.exercise.let { exercise ->
                    exerciseIV.setImageResource(exercise.imageResource)
                    @Suppress("DEPRECATION")
                    descriptionTV.text =
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                                Html.fromHtml(getString(exercise.descResource), Html.FROM_HTML_MODE_LEGACY)
                            else
                                Html.fromHtml(getString(exercise.descResource))
                }

                if (exerciseMeta.isFlipped) {
                    exerciseIV.scaleX = -1f
                }
            }

            exerciseIV.setOnClickListener((activity as WorkoutActivity3).pausePlayListener)

            val collapseDrawable = AppCompatResources.getDrawable(context!!, R.drawable.ic_expand_up)
            titleB.setCompoundDrawablesWithIntrinsicBounds(null, null, collapseDrawable, null)
            titleB.setOnClickListener {
                toggleDescription()
            }
        }

        val workoutActivity = activity as WorkoutActivity3
        if (workoutActivity.needsRerender) {
            workoutActivity.forceRender()
            workoutActivity.needsRerender = false
        }
    }

    override fun onDestroyView() {
        viewCreated = false
        super.onDestroyView()
    }

    //
    // WorkoutContract.View
    //
    fun setExercise() { //todo flip if flipped
        if (viewCreated) {
            exerciseMeta?.exercise?.let {
                titleB.text = getString(it.titleResource)
            }
            exerciseIV.colorFilter = null
        } else (activity as WorkoutActivity?)?.needsRerender = true
    }

    fun setBreak() {
        if (viewCreated) {
            exerciseMeta?.exercise?.let {
                titleB.text = String.format(
                        getString(R.string.next_label),
                        getString(it.titleResource)
                )
            }
            exerciseIV.colorFilter = grayscaleFilter
        } else (activity as WorkoutActivity?)?.needsRerender = true
    }

    fun setPlaying() {
        if (viewCreated) {
            @Suppress("DEPRECATION")
            if (Build.VERSION.SDK_INT >= 16)
                exerciseIV.imageAlpha = 255
            else
                exerciseIV.setAlpha(255)
        } else (activity as WorkoutActivity?)?.needsRerender = true
    }

    fun setPaused() { //todo visibility failing on rotate sometime! I guess setPaused isn't called sometime!!!
        if (viewCreated) {
            @Suppress("DEPRECATION")
            if (Build.VERSION.SDK_INT >= 16)
                exerciseIV.imageAlpha = 128
            else
                exerciseIV.setAlpha(128)
        } else (activity as WorkoutActivity?)?.needsRerender = true
    }

    //
    // Custom display
    //

    private fun toggleDescription() { //todo this might not work
        activity?.runOnUiThread {
            if (descriptionFrameSV.visibility == View.GONE) {
                descriptionFrameSV.visibility = View.VISIBLE
                val downCollapseDrawable = AppCompatResources.getDrawable(context!!, R.drawable.ic_collapse_down)
                titleB.setCompoundDrawablesWithIntrinsicBounds(null, null, downCollapseDrawable, null)
            } else {
                descriptionFrameSV.visibility = View.GONE
                val upCollapseDrawable = AppCompatResources.getDrawable(context!!, R.drawable.ic_expand_up)
                titleB.setCompoundDrawablesWithIntrinsicBounds(null, null, upCollapseDrawable, null)
            }
        }
    }
}