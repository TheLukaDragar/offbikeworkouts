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

package com.dragar.luka.offbikeworkouts.components

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent


class OptionalSwipeViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {
    private var canSwipe = false

    override fun onTouchEvent(event: MotionEvent) =
            if (canSwipe) super.onTouchEvent(event) else false

    override fun onInterceptTouchEvent(event: MotionEvent) =
            if (canSwipe) super.onInterceptTouchEvent(event) else false
}