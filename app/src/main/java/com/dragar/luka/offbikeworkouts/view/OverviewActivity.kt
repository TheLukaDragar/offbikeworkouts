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
import android.widget.TextView
import com.dragar.luka.offbikeworkouts.R
import com.dragar.luka.offbikeworkouts.model.Workout
import com.dragar.luka.offbikeworkouts.model.WorkoutRepository
import kotlinx.android.synthetic.main.activity_overview.*
import java.lang.ref.WeakReference


class OverviewActivity : AppCompatActivity() {
    //todo make sure the exercise view loads back if service is in background

    override fun onCreate(savedInstanceState: Bundle?) { //todo connect service and preload here
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        workoutRV.layoutManager = LinearLayoutManager(this)
        workoutRV.adapter = WorkoutAdapter(WorkoutRepository.retrieveAll(), WeakReference(workoutRV))
        workoutRV.addOnItemTouchListener(object: RecyclerView.SimpleOnItemTouchListener() {

        })
    }

    internal class WorkoutAdapter(private val workouts: List<Workout>, private val recyclerView: WeakReference<RecyclerView>)
        : RecyclerView.Adapter<WorkoutAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_workout, parent, false)
            view.setOnClickListener {
                val recycler = recyclerView.get()

                val itemPosition = recycler?.getChildAdapterPosition(view) ?: 0
                val workout = workouts[itemPosition]

                val startIntent = Intent(recycler?.context, CoverActivity::class.java)
                startIntent.putExtra(CoverActivity.WORKOUT_KEY, workout)
                recycler?.context?.startActivity(startIntent)
            }
            return ViewHolder(view)
        }

        override fun getItemCount() = workouts.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.title.setText(workouts[position].titleResource)
        }

        internal class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
            var title = item.findViewById<View>(R.id.title) as TextView
        }
    }
    //todo consider creating service here, then just passing it onto the activity created
}