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

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.content.ContextCompat
import com.dragar.luka.offbikeworkouts.R
import com.dragar.luka.offbikeworkouts.WorkoutContract3
import com.dragar.luka.offbikeworkouts.model.ExerciseMeta3
import java.lang.ref.WeakReference

class WorkoutNotification3(initService: Service, activityIntent: PendingIntent) : WorkoutContract3.View { //todo bug seconds shown wrong

    private val service = WeakReference<Service>(initService)

    companion object {
        private const val channelID = "com.dragar.luka.offbikeworkouts.view.WorkoutNotification2"

        @RequiresApi(Build.VERSION_CODES.O)
        fun createNotificationChannel(notificationManager: NotificationManager, name: String, description: String) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelID, name, importance)
            channel.description = description
            notificationManager.createNotificationChannel(channel)
        }
    }

    private val notificationID = 1
    private val notificationManagerCompat = NotificationManagerCompat.from(initService)
    private val notificationBuilder = NotificationCompat.Builder(initService, channelID)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC) // lock screen controls, with sensitive content
            .setSmallIcon(R.drawable.ic_logo)
            .setColor(ContextCompat.getColor(initService, R.color.colorPrimary))
            .setContentText(initService.getString(R.string.notification_subtitle))
            .setContentIntent(activityIntent)
            .setUsesChronometer(true)
            .setShowWhen(false)
    private val exerciseTitleTemplate = initService.getString(R.string.notification_title)
    private val breakTitleTemplate = initService.getString(R.string.next_label)

    private var secondsSet = false
    private var curSecondLimit = 0

    init {
        initService.startForeground(notificationID, notificationBuilder.build())
    }

    override fun setExercise(workoutPos: Int, exerciseMeta: ExerciseMeta3) {
        val exercise = exerciseMeta.exercise
        curSecondLimit = exerciseMeta.duration
        val notification = notificationBuilder
                .setWhen(System.currentTimeMillis() - 1000)
                .setContentTitle(String.format(exerciseTitleTemplate,
                        service.get()?.getString(exercise.titleResource),
                        curSecondLimit))
                .build()
        notificationManagerCompat.notify(notificationID, notification)
    }

    override fun setBreak(workoutPos: Int, nextExerciseMeta: ExerciseMeta3, breakLength: Int) {
        curSecondLimit = breakLength

        val service = service.get()
        if (service != null) {
            val nextExercise = nextExerciseMeta.exercise
            val notification = notificationBuilder
                    .setWhen(System.currentTimeMillis() - 1000)
                    .setContentTitle(
                            String.format(
                                    breakTitleTemplate,
                                    service.getString(nextExercise.titleResource)))
                    .build()
            notificationManagerCompat.notify(notificationID, notification)
        }
    }

    override fun showFinish() {
        val notification = notificationBuilder
                .setUsesChronometer(false)
                .setContentTitle(service.get()?.getString(R.string.done_title))
                .build()
        notificationManagerCompat.notify(notificationID, notification)
    }

    override fun setSeconds(seconds: Int) {
        if (!secondsSet) {
            val notification = notificationBuilder
                    .setWhen(System.currentTimeMillis() - (curSecondLimit - seconds) * 1000)
                    .build()
            notificationManagerCompat.notify(notificationID, notification)
            secondsSet = true
        }
    }

    override fun setPaused() {
        secondsSet = false
        val notification = notificationBuilder
                .setShowWhen(false)
                .build()
        notificationManagerCompat.notify(notificationID, notification)
    }

    override fun setPlaying() {
        val notification = notificationBuilder
                .setShowWhen(true)
                .build()
        notificationManagerCompat.notify(notificationID, notification)
    }

    override fun close() {} //todo anything here?
}