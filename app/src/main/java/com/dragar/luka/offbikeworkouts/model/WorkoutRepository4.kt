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

import com.dragar.luka.offbikeworkouts.WorkoutContract3

/**
@author Miroslav Mazel
 */
object WorkoutRepository4 : WorkoutContract3.Model {
    private const val NULL_RESOURCE = android.R.color.transparent

    override fun retrieveAll(): List<Workout3> {
        return listOf(
                Workout3(
                        titleResource = R.string.Strech1,
                        titleResource2 = R.string.ADF,
                        img = R.drawable.color_back,
                        customColor = 0xff0B65DB,
                        exerciseMetas = arrayOf(
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_jumpingjacks,
                                                descResource = R.string.exercise_desc_jumpingjacks,
                                                imageResource = R.drawable.exercise_jumpingjacks
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_wallsit,
                                                descResource = R.string.exercise_desc_wallsit,
                                                imageResource = R.drawable.exercise_wallsit
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_pushups,
                                                descResource = R.string.exercise_desc_pushups,
                                                imageResource = R.drawable.exercise_pushup
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_abcrunches,
                                                descResource = R.string.exercise_desc_abcrunches,
                                                imageResource = R.drawable.exercise_abcrunch
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_stepups,
                                                descResource = R.string.exercise_desc_stepups,
                                                imageResource = R.drawable.exercise_stepup
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_squats,
                                                descResource = R.string.exercise_desc_squats,
                                                imageResource = R.drawable.exercise_squat
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_tricepsdips,
                                                descResource = R.string.exercise_desc_tricepsdips,
                                                imageResource = R.drawable.exercise_tricepsdip
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_plank,
                                                descResource = R.string.exercise_desc_plank,
                                                imageResource = R.drawable.exercise_plank
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_highknees,
                                                descResource = R.string.exercise_desc_highknees,
                                                imageResource = R.drawable.exercise_highknees
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_lunges,
                                                descResource = R.string.exercise_desc_lunges,
                                                imageResource = R.drawable.exercise_lunge
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_pushuprotations,
                                                descResource = R.string.exercise_desc_pushuprotations,
                                                imageResource = R.drawable.exercise_pushuprotation
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_l,
                                                descResource = R.string.exercise_desc_sideplank_l,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_r,
                                                descResource = R.string.exercise_desc_sideplank_r,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30, isFlipped = true)
                        ),
                        breakLength = 10
                ),

                Workout3(
                        titleResource = R.string.workout_title_7minute,
                titleResource2 = R.string.ADF,
                img = R.drawable.color_back,
                customColor = 0xff0B65DB,
                exerciseMetas = arrayOf(
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_jumpingjacks,
                                        descResource = R.string.exercise_desc_jumpingjacks,
                                        imageResource = R.drawable.exercise_jumpingjacks
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_wallsit,
                                        descResource = R.string.exercise_desc_wallsit,
                                        imageResource = R.drawable.exercise_wallsit
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_pushups,
                                        descResource = R.string.exercise_desc_pushups,
                                        imageResource = R.drawable.exercise_pushup
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_abcrunches,
                                        descResource = R.string.exercise_desc_abcrunches,
                                        imageResource = R.drawable.exercise_abcrunch
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_stepups,
                                        descResource = R.string.exercise_desc_stepups,
                                        imageResource = R.drawable.exercise_stepup
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_squats,
                                        descResource = R.string.exercise_desc_squats,
                                        imageResource = R.drawable.exercise_squat
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_tricepsdips,
                                        descResource = R.string.exercise_desc_tricepsdips,
                                        imageResource = R.drawable.exercise_tricepsdip
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_plank,
                                        descResource = R.string.exercise_desc_plank,
                                        imageResource = R.drawable.exercise_plank
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_highknees,
                                        descResource = R.string.exercise_desc_highknees,
                                        imageResource = R.drawable.exercise_highknees
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_lunges,
                                        descResource = R.string.exercise_desc_lunges,
                                        imageResource = R.drawable.exercise_lunge
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_pushuprotations,
                                        descResource = R.string.exercise_desc_pushuprotations,
                                        imageResource = R.drawable.exercise_pushuprotation
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_sideplank_l,
                                        descResource = R.string.exercise_desc_sideplank_l,
                                        imageResource = R.drawable.exercise_sideplank
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_sideplank_r,
                                        descResource = R.string.exercise_desc_sideplank_r,
                                        imageResource = R.drawable.exercise_sideplank
                                ), 30, isFlipped = true)
                ),
                breakLength = 10
        ),
                                Workout3(
                                titleResource = R.string.workout_title_7minute,
                titleResource2 = R.string.ADF,
                img = R.drawable.color_back,
                customColor = 0xff0B65DB,
                exerciseMetas = arrayOf(
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_jumpingjacks,
                                        descResource = R.string.exercise_desc_jumpingjacks,
                                        imageResource = R.drawable.exercise_jumpingjacks
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_wallsit,
                                        descResource = R.string.exercise_desc_wallsit,
                                        imageResource = R.drawable.exercise_wallsit
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_pushups,
                                        descResource = R.string.exercise_desc_pushups,
                                        imageResource = R.drawable.exercise_pushup
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_abcrunches,
                                        descResource = R.string.exercise_desc_abcrunches,
                                        imageResource = R.drawable.exercise_abcrunch
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_stepups,
                                        descResource = R.string.exercise_desc_stepups,
                                        imageResource = R.drawable.exercise_stepup
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_squats,
                                        descResource = R.string.exercise_desc_squats,
                                        imageResource = R.drawable.exercise_squat
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_tricepsdips,
                                        descResource = R.string.exercise_desc_tricepsdips,
                                        imageResource = R.drawable.exercise_tricepsdip
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_plank,
                                        descResource = R.string.exercise_desc_plank,
                                        imageResource = R.drawable.exercise_plank
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_highknees,
                                        descResource = R.string.exercise_desc_highknees,
                                        imageResource = R.drawable.exercise_highknees
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_lunges,
                                        descResource = R.string.exercise_desc_lunges,
                                        imageResource = R.drawable.exercise_lunge
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_pushuprotations,
                                        descResource = R.string.exercise_desc_pushuprotations,
                                        imageResource = R.drawable.exercise_pushuprotation
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_sideplank_l,
                                        descResource = R.string.exercise_desc_sideplank_l,
                                        imageResource = R.drawable.exercise_sideplank
                                ), 30),
                        ExerciseMeta3(
                                Exercise(
                                        titleResource = R.string.exercise_title_sideplank_r,
                                        descResource = R.string.exercise_desc_sideplank_r,
                                        imageResource = R.drawable.exercise_sideplank
                                ), 30, isFlipped = true)
                ),
                breakLength = 10
        ),
                Workout3(
                        titleResource = R.string.workout_title_7minute,
                        titleResource2 = R.string.ADF,
                        img = R.drawable.color_back,
                        customColor = 0xff0B65DB,
                        exerciseMetas = arrayOf(
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_jumpingjacks,
                                                descResource = R.string.exercise_desc_jumpingjacks,
                                                imageResource = R.drawable.exercise_jumpingjacks
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_wallsit,
                                                descResource = R.string.exercise_desc_wallsit,
                                                imageResource = R.drawable.exercise_wallsit
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_pushups,
                                                descResource = R.string.exercise_desc_pushups,
                                                imageResource = R.drawable.exercise_pushup
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_abcrunches,
                                                descResource = R.string.exercise_desc_abcrunches,
                                                imageResource = R.drawable.exercise_abcrunch
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_stepups,
                                                descResource = R.string.exercise_desc_stepups,
                                                imageResource = R.drawable.exercise_stepup
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_squats,
                                                descResource = R.string.exercise_desc_squats,
                                                imageResource = R.drawable.exercise_squat
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_tricepsdips,
                                                descResource = R.string.exercise_desc_tricepsdips,
                                                imageResource = R.drawable.exercise_tricepsdip
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_plank,
                                                descResource = R.string.exercise_desc_plank,
                                                imageResource = R.drawable.exercise_plank
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_highknees,
                                                descResource = R.string.exercise_desc_highknees,
                                                imageResource = R.drawable.exercise_highknees
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_lunges,
                                                descResource = R.string.exercise_desc_lunges,
                                                imageResource = R.drawable.exercise_lunge
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_pushuprotations,
                                                descResource = R.string.exercise_desc_pushuprotations,
                                                imageResource = R.drawable.exercise_pushuprotation
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_l,
                                                descResource = R.string.exercise_desc_sideplank_l,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_r,
                                                descResource = R.string.exercise_desc_sideplank_r,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30, isFlipped = true)
                        ),
                        breakLength = 10
                ),
                Workout3(
                        titleResource = R.string.workout_title_7minute,
                        titleResource2 = R.string.ADF,
                        img = R.drawable.color_back,
                        customColor = 0xff0B65DB,
                        exerciseMetas = arrayOf(
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_jumpingjacks,
                                                descResource = R.string.exercise_desc_jumpingjacks,
                                                imageResource = R.drawable.exercise_jumpingjacks
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_wallsit,
                                                descResource = R.string.exercise_desc_wallsit,
                                                imageResource = R.drawable.exercise_wallsit
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_pushups,
                                                descResource = R.string.exercise_desc_pushups,
                                                imageResource = R.drawable.exercise_pushup
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_abcrunches,
                                                descResource = R.string.exercise_desc_abcrunches,
                                                imageResource = R.drawable.exercise_abcrunch
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_stepups,
                                                descResource = R.string.exercise_desc_stepups,
                                                imageResource = R.drawable.exercise_stepup
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_squats,
                                                descResource = R.string.exercise_desc_squats,
                                                imageResource = R.drawable.exercise_squat
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_tricepsdips,
                                                descResource = R.string.exercise_desc_tricepsdips,
                                                imageResource = R.drawable.exercise_tricepsdip
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_plank,
                                                descResource = R.string.exercise_desc_plank,
                                                imageResource = R.drawable.exercise_plank
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_highknees,
                                                descResource = R.string.exercise_desc_highknees,
                                                imageResource = R.drawable.exercise_highknees
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_lunges,
                                                descResource = R.string.exercise_desc_lunges,
                                                imageResource = R.drawable.exercise_lunge
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_pushuprotations,
                                                descResource = R.string.exercise_desc_pushuprotations,
                                                imageResource = R.drawable.exercise_pushuprotation
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_l,
                                                descResource = R.string.exercise_desc_sideplank_l,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_r,
                                                descResource = R.string.exercise_desc_sideplank_r,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30, isFlipped = true)
                        ),
                        breakLength = 10
                ),
                Workout3(
                        titleResource = R.string.workout_title_7minute,
                        titleResource2 = R.string.ADF,
                        img = R.drawable.color_back,
                        customColor = 0xff0B65DB,
                        exerciseMetas = arrayOf(
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_jumpingjacks,
                                                descResource = R.string.exercise_desc_jumpingjacks,
                                                imageResource = R.drawable.exercise_jumpingjacks
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_wallsit,
                                                descResource = R.string.exercise_desc_wallsit,
                                                imageResource = R.drawable.exercise_wallsit
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_pushups,
                                                descResource = R.string.exercise_desc_pushups,
                                                imageResource = R.drawable.exercise_pushup
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_abcrunches,
                                                descResource = R.string.exercise_desc_abcrunches,
                                                imageResource = R.drawable.exercise_abcrunch
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_stepups,
                                                descResource = R.string.exercise_desc_stepups,
                                                imageResource = R.drawable.exercise_stepup
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_squats,
                                                descResource = R.string.exercise_desc_squats,
                                                imageResource = R.drawable.exercise_squat
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_tricepsdips,
                                                descResource = R.string.exercise_desc_tricepsdips,
                                                imageResource = R.drawable.exercise_tricepsdip
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_plank,
                                                descResource = R.string.exercise_desc_plank,
                                                imageResource = R.drawable.exercise_plank
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_highknees,
                                                descResource = R.string.exercise_desc_highknees,
                                                imageResource = R.drawable.exercise_highknees
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_lunges,
                                                descResource = R.string.exercise_desc_lunges,
                                                imageResource = R.drawable.exercise_lunge
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_pushuprotations,
                                                descResource = R.string.exercise_desc_pushuprotations,
                                                imageResource = R.drawable.exercise_pushuprotation
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_l,
                                                descResource = R.string.exercise_desc_sideplank_l,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30),
                                ExerciseMeta3(
                                        Exercise(
                                                titleResource = R.string.exercise_title_sideplank_r,
                                                descResource = R.string.exercise_desc_sideplank_r,
                                                imageResource = R.drawable.exercise_sideplank
                                        ), 30, isFlipped = true)
                        ),
                        breakLength = 10
                )

//                , Workout( // for testing purposes only
//                        titleResource = R.string.workout_title_7minute,
//                        customColor = 0xff0B65DB,
//                        ExerciseMeta3s = arrayOf(
//                                ExerciseMeta3(
//                                        Exercise(
//                                                titleResource = R.string.exercise_title_jumpingjacks,
//                                                descResource = R.string.exercise_desc_jumpingjacks,
//                                                imageResource = R.drawable.exercise_jumpingjacks
//                                        ), 6),
//                                ExerciseMeta3(
//                                        Exercise(
//                                                titleResource = R.string.exercise_title_wallsit,
//                                                descResource = R.string.exercise_desc_wallsit,
//                                                imageResource = R.drawable.exercise_wallsit
//                                        ), 6, isFlipped = true),
//                                ExerciseMeta3(
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