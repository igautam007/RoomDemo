package com.gautamgelani.roomdemo.di

import android.content.Context
import androidx.room.Room
import com.gautamgelani.roomdemo.constant.AppConstant
import com.gautamgelani.roomdemo.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationCompenent (i.e. everywhere in the application)
    @Provides
    fun provideYourDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        AppConstant.HI_Database_Name
    )
        .allowMainThreadQueries()
        .build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun getStateDao(db: AppDatabase) = db.getSateDao()

    @Singleton
    @Provides
    fun getCountryDao(db: AppDatabase) = db.getCountryDao()

    @Singleton
    @Provides
    fun getOptionsCategoryDao(db: AppDatabase) = db.getOptionsCategoryDao()

    @Singleton
    @Provides
    fun getOptionsDao(db: AppDatabase) = db.getOptionDao()

}