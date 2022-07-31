package com.gautamgelani.roomdemo.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.gautamgelani.roomdemo.data.model.ServerResponseModel
import com.gautamgelani.roomdemo.network.CallFailedApiException
import com.gautamgelani.roomdemo.network.NetworkStatus
import com.gautamgelani.roomdemo.network.NoInternetException
import com.orhanobut.logger.Logger
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

open class BaseRepository(@ApplicationContext val applicationContext: Context) {

    var networkStatus = MutableLiveData<NetworkStatus>()

    fun getNetworkStates() = networkStatus

    suspend inline fun <T> runApi(
        crossinline apiCall: suspend () -> Response<ServerResponseModel<T>>,
        apiName: String = ""
    ): T? {
        return try {
            getNetworkStates().postValue(NetworkStatus.Running(apiName = apiName))

            //Invoke the function
            val response = apiCall.invoke()
            response.body()?.toString()?.let { Logger.e(it) }
            if (response.isSuccessful && response.body() != null) {
                //Alright our api call was success so post success
                if (response.body()?.res == "0") {
                    if (response.body()?.msg?.isNotEmpty() == true) {
                        response.body()?.msg?.let {
                            getNetworkStates().postValue(
                                NetworkStatus.Success(
                                    msg = it,
                                    apiName = apiName
                                )
                            )
                        }
                    } else
                        getNetworkStates().postValue(NetworkStatus.Success(apiName = apiName))
                    response.body()?.data
                } else {
                    getNetworkStates().postValue(
                        NetworkStatus.Failed(
                            response.body()?.msg ?: "Failed to call",
                            apiName = apiName
                        )
                    )
                    null
                }
            } else if (response.code() == 401) {
                getNetworkStates().postValue(
                    NetworkStatus.AuthToken(
                        apiName = apiName
                    )
                )
                null
            } else {
                getNetworkStates().postValue(NetworkStatus.Failed(apiName = apiName))
                Logger.e("Error", response.message())
                null
            }
        } catch (e: Exception) {
            //Oops we are in trouble lets dig our problem and post the status and return null as we didn't got any data
            when (e) {
                is SocketTimeoutException -> getNetworkStates().postValue(
                    NetworkStatus.NoInternet(
                        apiName = apiName
                    )
                )
                is IOException -> getNetworkStates().postValue(NetworkStatus.NoInternet(apiName = apiName))
                is NoInternetException -> getNetworkStates().postValue(
                    NetworkStatus.NoInternet(
                        apiName = apiName
                    )
                )
                else -> {
                    if (e.message.equals("StandaloneCoroutine was cancelled", true))
                        getNetworkStates().postValue(NetworkStatus.Failed(apiName = apiName))
                    else getNetworkStates().postValue(
                        NetworkStatus.Failed(
                            e.message ?: "",
                            apiName = apiName
                        )
                    )
                }
            }
            //We got nothing here so return null :( As our api has failed )
            e.message?.let { Logger.e("error", it) }
            null
        }
    }

    suspend inline fun <T> runApiWithCustomResponse(
        crossinline apiCall: suspend () -> Response<T>,
        apiName: String = ""
    ): T? {
        //  getNetworkStates().postValue(NetworkStatus.Running(apiName = apiName))
        // if (NetworkUtils.isOnline(applicationContext)) {
        return try {
            //Invoke the function
            val response = apiCall.invoke()
            response.body()?.toString()?.let { Logger.e(it) }
            if (response.isSuccessful && response.body() != null) {
                //Alright our api call was success so post success
                getNetworkStates().postValue(NetworkStatus.Success(apiName = apiName))
                response.body()
            } else if (response.code() == 401) {
                getNetworkStates().postValue(NetworkStatus.AuthToken(apiName = apiName))
                null
            } else {
                getNetworkStates().postValue(NetworkStatus.Failed(apiName = apiName))
                Logger.e("Error", response.message())
                null
            }
        } catch (e: Exception) {
            //Oops we are in trouble lets dig our problem and post the status and return null as we didn't got any data
            when (e) {
                //Lets dive into the exceptions
                is SocketTimeoutException -> getNetworkStates().postValue(
                    NetworkStatus.Failed(
                        apiName = apiName
                    )
                )
                is IOException -> getNetworkStates().postValue(NetworkStatus.Failed(apiName = apiName))
                is NoInternetException -> getNetworkStates().postValue(
                    NetworkStatus.NoInternet(
                        apiName = apiName
                    )
                )
                else -> {
                    if (e.message.equals("StandaloneCoroutine was cancelled", true))
                        getNetworkStates().postValue(NetworkStatus.Failed(apiName = apiName))
                    else getNetworkStates().postValue(
                        NetworkStatus.Failed(
                            e.message ?: "",
                            apiName = apiName
                        )
                    )
                }
            }
            //We got nothing here so return null :( As our api has failed )
            e.message?.let { Logger.e("error", it) }
            null
        }
        /*  } else {
              NetworkStatus.NoInternet(
                  apiName = apiName
              )
              null
          }*/
    }

    // You can use this method when you have to manually manage things like multiple API calls in single loader
    suspend inline fun <T : Any> apiRequest(
        crossinline call: suspend () -> Response<T>,
        apiName: String = ""
    ): T {
        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                Logger.e("response " + response.body())
                return response.body()!!
            } else {
                val error = response.errorBody()?.string()
                val message = StringBuilder()
                error?.let {
                    try {
                        message.append(JSONObject(it).getString("msg"))
                    } catch (e: Exception) {
                        message.append(e.message)
                    }
                }
                throw CallFailedApiException(message.toString())
            }
        } catch (e: Exception) {
            e.message?.let { Logger.e(it) }
            throw e
        }
    }
}