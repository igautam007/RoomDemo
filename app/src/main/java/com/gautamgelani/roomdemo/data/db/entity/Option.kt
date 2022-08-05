package com.gautamgelani.roomdemo.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Option(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    var option_id: Long = 0,
    val title: String? = "",
    val option_category_id: Long = 0L,
    val is_required_account: Int = 0,
    val icon_url: String? = "",
) : Parcelable