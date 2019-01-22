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

import com.dragar.luka.offbikeworkouts.WorkoutContract2

/**
@author Miroslav Mazel
 */
object WorkoutRepository2 : WorkoutContract2.Model {
    private const val NULL_RESOURCE = android.R.color.transparent

    override fun retrieveAll(): List<Workout2> {
        return listOf(
                Workout2(
                        titleResource = R.string.Strech1,
                        customColor = 0xff0B65DB,
                        exerciseMetas = arrayOf(

                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.dela,
                                                descResource = R.string.exercise_desc_jumpingjacks,
                                                imageResource = R.drawable.exercise_jumpingjacks
                                        ), 10),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_jumpingjacks,
                                                descResource = R.string.exercise_desc_jumpingjacks,
                                                imageResource = R.drawable.exercise_jumpingjacks
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_wallsit,
                                                descResource = R.string.exercise_desc_wallsit,
                                                imageResource = R.drawable.exercise_wallsit
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_pushups,
                                                descResource = R.string.exercise_desc_pushups,
                                                imageResource = R.drawable.exercise_pushup
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_abcrunches,
                                                descResource = R.string.exercise_desc_abcrunches,
                                                imageResource = R.drawable.exercise_abcrunch
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_stepups,
                                                descResource = R.string.exercise_desc_stepups,
                                                imageResource = R.drawable.exercise_stepup
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_squats,
                                                descResource = R.string.exercise_desc_squats,
                                                imageResource = R.drawable.exercise_squat
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_tricepsdips,
                                                descResource = R.string.exercise_desc_tricepsdips,
                                                imageResource = R.drawable.exercise_tricepsdip
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_plank,
                                                descResource = R.string.exercise_desc_plank,
                                                imageResource = R.drawable.exercise_plank
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_highknees,
                                                descResource = R.string.exercise_desc_highknees,
                                                imageResource = R.drawable.exercise_highknees
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_lunges,
                                                descResource = R.string.exercise_desc_lunges,
                                                imageResource = R.drawable.exercise_lunge
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_pushuprotations,
                                                descResource = R.string.exercise_desc_pushuprotations,
                                                imageResource = R.drawable.exercise_pushuprotation
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_sideplank_l,
                                                descResource = R.string.exercise_desc_sideplank_l,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_sideplank_r,
                                                descResource = R.string.exercise_desc_sideplank_r,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30, isFlipped = true)
                        ),
                        breakLength = 10
                ),
                Workout2(
                        titleResource = R.string.workout_title_7minadvanced,
                        customColor = 0xffff5f00,
                        exerciseMetas = arrayOf(
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_reverselungerotaiton,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_sideplank_l,
                                                descResource = R.string.exercise_desc_sideplank_l,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_pushuprowburpee,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_sideplank_r,
                                                descResource = R.string.exercise_desc_sideplank_r,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30, isFlipped = true),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_romaniancurlpress_l,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_romaniancurlpress_r,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60, isFlipped = true),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_plankarmlift,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 30),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_laterallungetotricepsextension,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60),
                                ExerciseMeta2(
                                        Exercise2(
                                                titleResource = R.string.exercise_title_bentoverrow,
                                                descResource = R.string.tbd,
                                                imageResource = NULL_RESOURCE
                                        ), 60)
                        ),
                        breakLength = 10
                )

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

    }
}