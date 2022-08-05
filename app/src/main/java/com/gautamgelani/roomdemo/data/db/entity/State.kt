package com.gautamgelani.roomdemo.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class State(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var state_id: Long = 0,
    val state_name: String = "",
    val country_id: Long = 0L,
    val short_code: String? = ""
) : Parcelable