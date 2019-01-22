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

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import com.dragar.luka.offbikeworkouts.R
import com.dragar.luka.offbikeworkouts.WorkoutContract3
import com.dragar.luka.offbikeworkouts.model.ExerciseMeta3
import java.lang.ref.WeakReference

class WorkoutChime3(context: WeakReference<Context>) : WorkoutContract3.View {
    @Suppress("DEPRECATION")
    private val soundPool =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) SoundPool.Builder().build()
            else SoundPool(2, AudioManager.STREAM_MUSIC, 100)
    private val soundVolume = 1f
    private val soundStart = soundPool.load(context.get(), R.raw.exercise_start, 1)
    private val soundBreak = soundPool.load(context.get(), R.raw.exercise_break, 1)
    private val soundFinish = soundPool.load(context.get(), R.raw.exercise_finish, 1)
    private val soundTick = soundPool.load(context.get(), R.raw.time_tick, 1)
    private val countdown = 5

    private var chimeLoaded = false

    init {
        soundPool.setOnLoadCompleteListener { _, _, _ -> chimeLoaded = true }
    }

    override fun setExercise(workoutPos: Int, exerciseMeta: ExerciseMeta3) {
        soundPool.play(soundStart, soundVolume, soundVolume, 1, 0, 1f)
    }

    override fun setBreak(workoutPos: Int, nextExerciseMeta: ExerciseMeta3, breakLength: Int) {
        soundPool.play(soundBreak, soundVolume, soundVolume, 1, 0, 1f)
    }

    override fun showFinish() {
        soundPool.play(soundFinish, soundVolume, soundVolume, 1, 0, 1f)
    }

    override fun setSeconds(seconds: Int) {
        if (seconds <= countdown)
            soundPool.play(soundTick, soundVolume, soundVolume, 1, 0, 1f)
    }

    override fun setPaused() {}

    override fun setPlaying() {}

    override fun close() {
        soundPool.release()
    }
}