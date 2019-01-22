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

import android.os.Parcel
import android.os.Parcelable

/**
@author Miroslav Mazel
 */
class ExerciseMeta2(val exercise: Exercise2, val duration: Int, val isFlipped: Boolean = false) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(Exercise2::class.java.classLoader),
            parcel.readInt(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(exercise, flags)
        parcel.writeInt(duration)
        parcel.writeByte(if (isFlipped) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExerciseMeta2> {
        override fun createFromParcel(parcel: Parcel): ExerciseMeta2 {
            return ExerciseMeta2(parcel)
        }

        override fun newArray(size: Int): Array<ExerciseMeta2?> {
            return arrayOfNulls(size)
        }
    }
}