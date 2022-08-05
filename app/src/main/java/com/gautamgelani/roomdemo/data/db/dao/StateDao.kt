package com.gautamgelani.roomdemo.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.gautamgelani.roomdemo.data.db.entity.State

@Dao
interface StateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(state: List<State>)

}