package com.gautamgelani.roomdemo.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.gautamgelani.roomdemo.data.db.entity.Country

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(country: List<Country>)

}