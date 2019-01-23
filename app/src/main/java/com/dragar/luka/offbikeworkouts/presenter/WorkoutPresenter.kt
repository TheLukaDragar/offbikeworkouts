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

import android.os.Parcel
import android.os.Parcelable
import com.dragar.luka.offbikeworkouts.WorkoutContract
import com.dragar.luka.offbikeworkouts.model.Workout
import java.lang.ref.WeakReference
import java.util.*


/**
@author Miroslav Mazel
 */

internal class WorkoutPresenter : WorkoutTimer.TimerCallback {
    // todo add prep for start and for restoring cur exercise

    //todo check that proguard handles enums effectively
    enum class Stage { EXERCISE, BREAK, END }

    class WorkoutPresenterState(val workout: Workout,
                                val exercisePos: Int,
                                val timeRemaining: Int,
                                val isTimerRunning: Boolean,
                                val stage: Stage) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readParcelable(Workout::class.java.classLoader),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readByte() != 0.toByte(),
                Stage.values()[parcel.readInt()])

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(workout, flags)
            parcel.writeInt(exercisePos)
            parcel.writeInt(timeRemaining)
            parcel.writeByte(if (isTimerRunning) 1 else 0)
            parcel.writeInt(stage.ordinal)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<WorkoutPresenterState> {
            override fun createFromParcel(parcel: Parcel): WorkoutPresenterState {
                return WorkoutPresenterState(parcel)
            }

            override fun newArray(size: Int): Array<WorkoutPresenterState?> {
                return arrayOfNulls(size)
            }
        }
    }

    private val prepLength = 10

    private val workout: Workout
    private val timer: WorkoutTimer

    private var views = ArrayList<WeakReference<WorkoutContract.View>>(3)
    private var exercisePos: Int
    private var stage: Stage

    private val curExerciseMeta
        get() = workout.exerciseMetas[exercisePos]

    private val curExerciseLength
        get() = curExerciseMeta.duration

    private val isFirstExercise: Boolean
        get() = exercisePos == 0

    private val isLastExercise: Boolean
        get() = exercisePos == workout.size - 1

    constructor(workout: Workout, vararg callbacks: WeakReference<WorkoutContract.View>) {
        this.workout = workout
        exercisePos = 0
        stage = Stage.BREAK

        for (view in callbacks) {
            views.add(view)
        }

        timer = WorkoutTimer(this, prepLength)

        renderStage(views)
        renderSeconds(views) // todo remove once I add PREPARED state

        timer.start()
    }

    constructor(savedState: Parcelable, vararg callbacks: WeakReference<WorkoutContract.View>) {
        this.workout = (savedState as WorkoutPresenterState).workout
        exercisePos = savedState.exercisePos
        stage = savedState.stage

        for (view in callbacks) {
            views.add(view)
        }

        timer = WorkoutTimer(this, savedState.timeRemaining)

        rerender(views)

        if (savedState.isTimerRunning) timer.start()
        else timer.stop()
    }

    //
    // Timer
    //

    override fun onSecondDecrease() {
        for (view in views) view.get()?.setSeconds(timer.timeRemaining)
    }

    override fun onTimerZero() { //todo make a test for switching states correctly
        when (stage) {
            Stage.BREAK -> setUpExerciseStage()

            Stage.EXERCISE -> {
                if (isLastExercise) setUpEndStage()
                else {
                    exercisePos++
                    setUpBreakStage()
                }
            }
        }
    }

    //
    // Stages
    //

    private fun setUpExerciseStage() {
        stage = Stage.EXERCISE
        renderStage(views)

        timer.timeRemaining = curExerciseLength
        renderSeconds(views)

        renderPausePlay(views)
    }

    private fun setUpBreakStage() { //todo say what to prepare (e.g. chair, mat, sthing else)!
        stage = Stage.BREAK
        renderStage(views)

        timer.timeRemaining = workout.breakLength
        renderSeconds(views)

        renderPausePlay(views)
    }

    private fun setUpEndStage() {
        timer.stop()

        stage = Stage.END
        renderStage(views)
    }

    fun close() {
        timer.close()
        views.clear()
    }

    //
    // Android lifecycle
    //

    //todo assign exercise on bind

    //
    // View render
    //

    private fun rerender(renderViews: Iterable<WeakReference<WorkoutContract.View>>) {
        renderStage(renderViews)

        if (stage == Stage.EXERCISE || stage == Stage.BREAK) {
            renderPausePlay(renderViews)
            renderSeconds(renderViews)
        }
    }

    private fun renderStage(renderViews: Iterable<WeakReference<WorkoutContract.View>>) {
        when (stage) {
            Stage.EXERCISE -> for (view in renderViews) view.get()?.setExercise(exercisePos, curExerciseMeta)
            Stage.BREAK -> for (view in renderViews) view.get()?.setBreak(exercisePos, curExerciseMeta, workout.breakLength)
            Stage.END -> for (view in renderViews) view.get()?.showFinish()
        }
    }

    private fun renderPausePlay(renderViews: Iterable<WeakReference<WorkoutContract.View>>) {
        if (timer.running) for (view in renderViews) view.get()?.setPlaying()
        else for (view in renderViews) view.get()?.setPaused()
    }

    private fun renderSeconds(renderViews: Iterable<WeakReference<WorkoutContract.View>>) {
        for (view in renderViews) view.get()?.setSeconds(timer.timeRemaining)
    }

    //
    // WorkoutContract.Presenter
    //
    /* override fun changeWorkout(workout: Workout) {
        this.state = InternalState(workout = workout)
    } */

    fun renderToView(view: WorkoutContract.View) {
        rerender(Collections.singleton(WeakReference(view)))
    }

    fun addViews(vararg callbacks: WeakReference<WorkoutContract.View>) {
        views.addAll(callbacks)
        rerender(callbacks.asIterable())
    }

    fun removeView(view: WorkoutContract.View) {
        val iterator = views.iterator()
        while (iterator.hasNext()) {
            val weakRef = iterator.next()
            if (weakRef.get() === view) {
                iterator.remove()
            }
        }
    }

    fun getSavedState(): Parcelable {
        return WorkoutPresenterState(
                workout = workout,
                exercisePos = exercisePos,
                timeRemaining = timer.timeRemaining,
                stage = stage,
                isTimerRunning = timer.running
        )
    }

    fun togglePlayPause() {
        if (stage == Stage.EXERCISE || stage == Stage.BREAK) {
            if (timer.running) {
                timer.stop()
                renderPausePlay(views)
            } else {
                timer.start()
                renderPausePlay(views)
            }
        }
    }

    fun isPlaying(): Boolean {
        return timer.running
    }

    fun skipToPreviousExercise() {
        if (!isFirstExercise) {
            exercisePos--

            setUpExerciseStage()
        } else {
            timer.timeRemaining = curExerciseLength
        }
    }

    fun skipToNextExercise() {
        if (!isLastExercise) {
            exercisePos++

            setUpExerciseStage()
        }
    }
}