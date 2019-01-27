package com.dragar.luka.offbikeworkouts

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.dragar.luka.offbikeworkouts.model.Exercise
import com.dragar.luka.offbikeworkouts.model.ExerciseMeta
import com.dragar.luka.offbikeworkouts.model.Workout
import com.dragar.luka.offbikeworkouts.model.WorkoutRepository
import com.dragar.luka.offbikeworkouts.view.CoverActivity
import com.dragar.luka.offbikeworkouts.view.OverviewActivity

class start : AppCompatActivity()
{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_act)
        startplz()
        finish()


        // get reference to button
        val btn_click_me = findViewById<Button>(R.id.btn_click_me)
        // set on-click listener
        btn_click_me.setOnClickListener {
            // your code to perform when the user clicks on the button
            Toast.makeText(this@start, "You clicked me.", Toast.LENGTH_SHORT).show()
            startplz()








            //val intent = Intent(this,OverviewActivity::class.java) startActivity(intent)
            //val startIntent = Intent(start, CoverActivity::class.java)
           // startIntent.putExtra(CoverActivity.WORKOUT_KEY, workout)
                   // .startActivity(startIntent)
        }




    }

    private fun startplz() {
        val intent = Intent(this,CoverActivity::class.java)

        val workout = Workout(
                titleResource = R.string.streching,
                titleResource2 = R.string.HA,
                img = R.drawable.f,
                customColor = 0xffff5f00,
                exerciseMetas = arrayOf(
                        ExerciseMeta(
                                Exercise(
                                        titleResource = R.string.exercise_title_reverselungerotaiton,
                                        descResource = R.string.tbd,
                                        imageResource = R.raw.giphy
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
                                        imageResource = WorkoutRepository.NULL_RESOURCE
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
                                        imageResource = WorkoutRepository.NULL_RESOURCE
                                ), 60),
                        ExerciseMeta(
                                Exercise(
                                        titleResource = R.string.exercise_title_romaniancurlpress_r,
                                        descResource = R.string.tbd,
                                        imageResource = WorkoutRepository.NULL_RESOURCE
                                ), 60, isFlipped = true),
                        ExerciseMeta(
                                Exercise(
                                        titleResource = R.string.exercise_title_plankarmlift,
                                        descResource = R.string.tbd,
                                        imageResource = WorkoutRepository.NULL_RESOURCE
                                ), 30),
                        ExerciseMeta(
                                Exercise(
                                        titleResource = R.string.exercise_title_laterallungetotricepsextension,
                                        descResource = R.string.tbd,
                                        imageResource = WorkoutRepository.NULL_RESOURCE
                                ), 60),
                        ExerciseMeta(
                                Exercise(
                                        titleResource = R.string.exercise_title_bentoverrow,
                                        descResource = R.string.tbd,
                                        imageResource = WorkoutRepository.NULL_RESOURCE
                                ), 60)
                ),
                breakLength = 10

        )


        intent.putExtra(CoverActivity.WORKOUT_KEY,workout)
        startActivity(intent)
    }

}





