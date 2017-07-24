package com.werockstar.kotlin_workshop.model

import android.os.Parcel
import android.os.Parcelable

class Login constructor(var username: String, var password: String): Parcelable{
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Login> = object : Parcelable.Creator<Login> {
            override fun createFromParcel(source: Parcel): Login = Login(source)
            override fun newArray(size: Int): Array<Login?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(username)
        dest.writeString(password)
    }
}
