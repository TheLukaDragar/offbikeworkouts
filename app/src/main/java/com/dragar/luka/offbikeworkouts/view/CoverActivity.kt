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

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import com.dragar.luka.offbikeworkouts.R
import com.dragar.luka.offbikeworkouts.R.id.*
import kotlinx.android.synthetic.main.activity_cover.*

import com.dragar.luka.offbikeworkouts.model.Workout


/**
@author Miroslav Mazel
 */

//todo add license info
class CoverActivity : AppCompatActivity() {
    companion object {
        const val WORKOUT_KEY = "workout"
        const val PREFERENCES = "feeelPreferences"
        const val ENABLETTS_PREF = "enablettsPref"
    }

    override fun onCreate(savedInstanceState: Bundle?) { //todo connect service and preload here
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover)

        val workout = intent.getParcelableExtra(WORKOUT_KEY) as Workout
        titleTV.setText(workout.titleResource)

        val settings = getSharedPreferences(PREFERENCES, 0)
        enablettsCB.isChecked = settings.getBoolean(ENABLETTS_PREF, false)

        startExerciseB.setOnClickListener {
            val prefEdit = getSharedPreferences(PREFERENCES, 0).edit()
            prefEdit.putBoolean(ENABLETTS_PREF, enablettsCB.isChecked)
            prefEdit.apply()

            val startIntent = Intent(this, WorkoutActivity::class.java)
            startIntent.putExtra(WorkoutActivity.TTS_KEY, enablettsCB.isChecked)
            startIntent.putExtra(WorkoutActivity.WORKOUT_KEY, workout)
            startActivity(startIntent)
        }

        upB.setOnClickListener {
            NavUtils.navigateUpFromSameTask(this)
        }
    }
    //todo consider creating service here, then just passing it onto the activity created
}