package com.gautamgelani.roomdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gautamgelani.roomdemo.data.db.dao.CountryDao
import com.gautamgelani.roomdemo.data.db.dao.OptionDao
import com.gautamgelani.roomdemo.data.db.dao.OptionsCategoryDao
import com.gautamgelani.roomdemo.data.db.dao.StateDao
import com.gautamgelani.roomdemo.data.db.entity.Country
import com.gautamgelani.roomdemo.data.db.entity.Option
import com.gautamgelani.roomdemo.data.db.entity.Options_Category
import com.gautamgelani.roomdemo.data.db.entity.State

@Database(
    entities = [State::class, Country::class, Options_Category::class, Option::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getSateDao(): StateDao
    abstract fun getCountryDao(): CountryDao
    abstract fun getOptionsCategoryDao(): OptionsCategoryDao
    abstract fun getOptionDao(): OptionDao
}