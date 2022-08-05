package com.gautamgelani.roomdemo.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Country(

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    var country_id: Long = 0L,
    val country_name: String? = ""
) : Parcelable