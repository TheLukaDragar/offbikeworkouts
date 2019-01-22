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
class Workout3(val titleResource: Int,
               val titleResource2: Int,
               val img: Int,
               val customColor: Long,
               val exerciseMetas: Array<ExerciseMeta3>,
               val breakLength: Int) : Parcelable {


    /**
     * customColor encoded as (A & 0xff) << 24 | (R & 0xff) << 16 | (G & 0xff) << 8 | (B & 0xff), can reference with e.g. 0xff0000ff
     */

    val size: Int
        get() = exerciseMetas.size

    constructor(parcel: Parcel) : this(


            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readLong(),
            parcel.createTypedArray(ExerciseMeta3),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeInt(titleResource)
        parcel.writeInt(titleResource2)
        parcel.writeInt(img)
        parcel.writeLong(customColor)
        parcel.writeTypedArray(exerciseMetas, flags)
        parcel.writeInt(breakLength)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Workout3> {
        override fun createFromParcel(parcel: Parcel): Workout3 {
            return Workout3(parcel)
        }

        override fun newArray(size: Int): Array<Workout3?> {
            return arrayOfNulls(size)
        }
    }
}