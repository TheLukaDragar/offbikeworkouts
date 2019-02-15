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
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dragar.luka.offbikeworkouts.R
import com.dragar.luka.offbikeworkouts.model.Workout3
import com.dragar.luka.offbikeworkouts.model.WorkoutRepository5
import kotlinx.android.synthetic.main.activity_overview4.*
import java.lang.ref.WeakReference


class OverviewActivity5 : AppCompatActivity() {
    //todo make sure the exercise view loads back if service is in background

    override fun onCreate(savedInstanceState: Bundle?) { //todo connect service and preload here
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview4)

        upB3.setOnClickListener {
            finish()

        }




        workoutRV.layoutManager = LinearLayoutManager(this)
        workoutRV.adapter = WorkoutAdapter(WorkoutRepository5.retrieveAll(), WeakReference(workoutRV))
        workoutRV.addOnItemTouchListener(object: RecyclerView.SimpleOnItemTouchListener() {

        })
    }

    internal class WorkoutAdapter(private val workouts: List<Workout3>, private val recyclerView: WeakReference<RecyclerView>)
        : RecyclerView.Adapter<WorkoutAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_workout, parent, false)
            view.setOnClickListener {
                val recycler = recyclerView.get()

                val itemPosition = recycler?.getChildAdapterPosition(view) ?: 0
                val workout = workouts[itemPosition]

                val startIntent = Intent(recycler?.context, CoverActivity3::class.java)
                startIntent.putExtra(CoverActivity3.WORKOUT_KEY3, workout)
                recycler?.context?.startActivity(startIntent)
            }
            return ViewHolder(view)
        }

        override fun getItemCount() = workouts.size
      //  val mojlist: IntArray = intArrayOf(10, 20, 30, 40, 50)

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.title.setText(workouts[position].titleResource)
            holder.title2.setText(workouts[position].titleResource2)
            holder.img2.setImageResource(workouts[position].img)

//            holder.img.setImageResource(workouts[position].titleResource)



        }

        internal class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
            var title = item.findViewById<View>(R.id.title) as TextView
            var title2 = item.findViewById<View>(R.id.title2) as TextView
            var img2 = item.findViewById<View>(R.id.imageView5) as ImageView
          //  var img = item.findViewById<View>(R.id.imageView6) as ImageView



        }
    }
    //todo consider creating service here, then just passing it onto the activity created
}


