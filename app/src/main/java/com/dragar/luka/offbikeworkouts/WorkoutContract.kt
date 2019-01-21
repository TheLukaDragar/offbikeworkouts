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

package com.dragar.luka.offbikeworkouts

import android.os.Parcelable
import com.dragar.luka.offbikeworkouts.model.ExerciseMeta
import com.dragar.luka.offbikeworkouts.model.Workout

/**
@author Miroslav Mazel
 */
interface WorkoutContract {
    interface Presenter {
        fun setHostView(callback: View, savedState: Parcelable?, workout: Workout, ttsEnabled: Boolean)
        fun saveState(): Parcelable?
        fun disconnect(view: View) //todo test that this is always called; OR use weakReference instead

        fun skipToPreviousExercise()
        fun skipToNextExercise()

        fun forceRender(view: View)

        fun togglePlayPause()
    }

    interface View {
        // todo add change exercise separately from setExercise, for both service and views fun changeExercise(workoutPos: Int, exerciseMeta: ExerciseMeta)
        fun setExercise(workoutPos: Int, exerciseMeta: ExerciseMeta)
        fun setBreak(workoutPos: Int, nextExerciseMeta: ExerciseMeta, breakLength: Int)
        fun showFinish()

        fun setSeconds(seconds: Int) // sets seconds for countdown, both before and during exercise

        fun setPaused()
        fun setPlaying()

        fun close()
    }

    interface Model {
        fun retrieveAll(): List<Workout>
    }
}