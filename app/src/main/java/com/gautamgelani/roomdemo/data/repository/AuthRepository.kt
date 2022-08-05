package com.gautamgelani.roomdemo.data.repository

import android.content.Context
import com.gautamgelani.roomdemo.constant.APIConstant
import com.gautamgelani.roomdemo.data.db.dao.CountryDao
import com.gautamgelani.roomdemo.data.db.dao.OptionsCategoryDao
import com.gautamgelani.roomdemo.data.db.dao.OptionDao
import com.gautamgelani.roomdemo.data.db.dao.StateDao
import com.gautamgelani.roomdemo.data.model.user.UserLoginDetail
import com.gautamgelani.roomdemo.network.ApiInterface
import com.google.gson.JsonObject
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthRepository @Inject constructor(
    @ApplicationContext context: Context,
    private val stateDao: StateDao,
    private val countryDao: CountryDao,
    private val optionsCategoryDao: OptionsCategoryDao,
    private val optionDao: OptionDao,
    private val apiInterface: ApiInterface
) : BaseRepository(context) {

    suspend fun doRequestForLogin(params: JsonObject): UserLoginDetail? {
        val call = apiInterface.doRequestForLogin(params)

        return runApiWithCustomResponse({
            call
        }, APIConstant.HI_LoginUrl)
    }

    suspend fun storeDataInDB(userLoginDetail: UserLoginDetail) {
        userLoginDetail.data?.state?.let { stateDao.insertAll(it) }
        userLoginDetail.data?.country?.let { countryDao.insertAll(it) }
        userLoginDetail.data?.option_categories?.let { optionsCategoryDao.insertAll(it) }
        userLoginDetail.data?.option?.let { optionDao.insertAll(it) }
    }

}