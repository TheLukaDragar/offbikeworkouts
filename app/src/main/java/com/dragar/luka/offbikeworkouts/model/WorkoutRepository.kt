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

package com.dragar.luka.offbikeworkouts.model

import com.dragar.luka.offbikeworkouts.R

import com.dragar.luka.offbikeworkouts.WorkoutContract

/**
@author Miroslav Mazel
 */
object WorkoutRepository : WorkoutContract.Model {
    private const val NULL_RESOURCE = android.R.color.transparent

    override fun retrieveAll(): List<Workout> {
        return listOf(
                Workout(
                        titleResource = R.string.Firstplank,
                        titleResource2 = R.string.starteasy,
                        img = R.drawable.color_back,
                        customColor = 0xff0B65DB,
                        exerciseMetas = arrayOf(
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_plank,
                                                descResource = R.string.exercise_desc_plank,
                                                imageResource = R.drawable.exercise_plank
                                        ), 30),
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_l,
                                                descResource = R.string.exercise_desc_sideplank_l,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30),

                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_r,
                                                descResource = R.string.exercise_desc_sideplank_r,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30, isFlipped = true),

                                        ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_plank,
                                                descResource = R.string.exercise_desc_plank,
                                                imageResource = R.drawable.exercise_plank
                                        ), 30)
                        ),
                        breakLength = 15
                ),
                Workout(
                        titleResource = R.string.workout_title_7minute,
                        titleResource2 = R.string.HA,
                        img = R.drawable.f,
                        customColor = 0xffff5f00,
                        exerciseMetas = arrayOf(
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_reverselungerotaiton,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 30),
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_l,
                                                descResource = R.string.exercise_desc_sideplank_l,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30),
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_pushuprowburpee,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60),
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_r,
                                                descResource = R.string.exercise_desc_sideplank_r,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30, isFlipped = true),
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_romaniancurlpress_l,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60),
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_romaniancurlpress_r,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60, isFlipped = true),
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_plankarmlift,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 30),
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_laterallungetotricepsextension,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60),
                                ExerciseMeta(
                                        Exercise(
                                                titleResource = R.string.exercise_title_bentoverrow,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60)
                        ),
                        breakLength = 10
                )
//                , Workout( // for testing purposes only
//                        titleResource = R.string.workout_title_7minute,
//                        customColor = 0xff0B65DB,
//                        exerciseMetas = arrayOf(
//                                ExerciseMeta(
//                                        Exercise(
//                                                titleResource = R.string.exercise_title_jumpingjacks,
//                                                descResource = R.string.exercise_desc_jumpingjacks,
//                                                imageResource = R.drawable.exercise_jumpingjacks
//                                        ), 6),
//                                ExerciseMeta(
//                                        Exercise(
//                                                titleResource = R.string.exercise_title_wallsit,
//                                                descResource = R.string.exercise_desc_wallsit,
//                                                imageResource = R.drawable.exercise_wallsit
//                                        ), 6, isFlipped = true),
//                                ExerciseMeta(
//                                        Exercise(
//                                                titleResource = R.string.exercise_title_pushups,
//                                                descResource = R.string.exercise_desc_pushups,
//                                                imageResource = R.drawable.exercise_pushup
//                                        ), 6, true)
//                        ),
//                        breakLength = 6
//                )
        )
    }
}