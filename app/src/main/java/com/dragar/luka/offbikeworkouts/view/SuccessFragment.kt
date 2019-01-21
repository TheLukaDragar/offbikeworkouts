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

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dragar.luka.offbikeworkouts.R
import kotlinx.android.synthetic.main.fragment_success.*

class SuccessFragment internal constructor() : Fragment() {

    companion object {
        private const val WORKOUT_COLOR = "clr"

        fun newInstance(workoutColor: Long): SuccessFragment {
            val fragment = SuccessFragment()
            val bundle = Bundle()
            bundle.putLong(WORKOUT_COLOR, workoutColor)
            return fragment
        }
    }

    private var workoutColor = -1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getLong(WORKOUT_COLOR)?.let { workoutColor = it }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.runOnUiThread {
            doneIB.setOnClickListener {
                activity?.finish()
            }
        }
    }
}