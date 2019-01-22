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

import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

/**
@author Miroslav Mazel
 */

class WorkoutTimer2(private val callback: TimerCallback, initTime: Int) {

    interface TimerCallback {
        fun onSecondDecrease()
        fun onTimerZero()
    }

    var timeRemaining = initTime
    private val exerciseExecutor = Executors.newScheduledThreadPool(1)
    private var timerFuture: Future<*>? = null
    var running = false

    fun start() {
        if (timerFuture == null) { //todo double-check if using futures right
            timerFuture = exerciseExecutor.scheduleAtFixedRate({ countSecond() }, 0, 1, TimeUnit.SECONDS) //todo is a try catch needed with the runnable?
            running = true
        }
    }

    fun stop() {
        timerFuture?.cancel(true) //todo double-check if using futures right
        timerFuture = null
        running = false
    }

    fun close() {
        exerciseExecutor.shutdown()
    }

    private fun countSecond() {
        if (timeRemaining == 1) {
            timeRemaining = 0
            callback.onTimerZero()
        } else if (timeRemaining > 0) {
            timeRemaining--
            callback.onSecondDecrease()
        }
    }
}