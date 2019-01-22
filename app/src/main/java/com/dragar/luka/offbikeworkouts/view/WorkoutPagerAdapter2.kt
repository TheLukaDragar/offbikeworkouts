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

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup
import com.dragar.luka.offbikeworkouts.model.Workout2
import com.dragar.luka.offbikeworkouts.view.SuccessFragment

internal class WorkoutPagerAdapter2(fragmentManager: FragmentManager, private val workout: Workout2) : FragmentStatePagerAdapter(fragmentManager) {
    companion object {
        internal const val COVER_INDEX = -1 //todo change, not used
        internal const val WORKOUT_INDEX_FIRST = 0 //todo increase with new types
        internal const val SUCCESS_INDEX_FROM_END = 1
    }

    private val successIndex = count - SUCCESS_INDEX_FROM_END

    private val fragmentMap = HashMap<Int, Fragment>()

    override fun getCount(): Int = workout.size + 1 //todo change when adding cover

    override fun getItem(index: Int): Fragment =
            when (index) {
                COVER_INDEX -> TODO("NOT IMPLEMENTED YET")
                successIndex -> SuccessFragment.newInstance(workout.customColor)
                else -> {
                    val workoutPos = index - WORKOUT_INDEX_FIRST
                    WorkoutFragment2.newInstance(
                            exerciseMeta = workout.exerciseMetas[workoutPos],
                            breakLength = workout.breakLength
                    )
                }
            }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)
        fragmentMap[position] = fragment as Fragment

        val workoutActivity = (container.context as? WorkoutActivity2)
        if (workoutActivity != null && workoutActivity.needsRerender) {
            workoutActivity.forceRender()
            workoutActivity.needsRerender = false
        }

        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        fragmentMap.remove(position)
        super.destroyItem(container, position, `object`)
    }

    fun getFragment(index: Int) = fragmentMap[index]
}