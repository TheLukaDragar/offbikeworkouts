package com.dragar.luka.offbikeworkouts

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.dragar.luka.offbikeworkouts.model.Workout
import com.dragar.luka.offbikeworkouts.view.CoverActivity
import com.dragar.luka.offbikeworkouts.view.OverviewActivity

class start : AppCompatActivity()
{

    companion object {
       // const val workouts = "workout"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_act)

        val workouts: List<Workout>

        //val workout = workouts[1]

        // get reference to button
        val btn_click_me = findViewById(R.id.btn_click_me) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            // your code to perform when the user clicks on the button
            Toast.makeText(this@start, "You clicked me.", Toast.LENGTH_SHORT).show()




            val intent = Intent(this,CoverActivity::class.java)

          //  intent.putExtra(CoverActivity.WORKOUT_KEY,workout)
            startActivity(intent)

           // val intent = Intent(this,OverviewActivity::class.java) startActivity(intent)
            //val startIntent = Intent(start, CoverActivity::class.java)
           // startIntent.putExtra(CoverActivity.WORKOUT_KEY, workout)
                   // .startActivity(startIntent)
        }




    }

}





