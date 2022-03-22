package com.zynksoftware.futureup.network

import android.content.Context
import android.util.Log
import com.zynksoftware.futureup.R
import retrofit2.HttpException

class NetworkExceptionHandler(private val context: Context) {

    fun <T> map(throwable: Throwable) : Resource<T> {
        Log.e(TAG, "", throwable)
        return when (throwable) {
            is HttpException -> mapHttpException(throwable)
            is NetworkNotAvailableException -> {
                Resource.Error(message = context.getString(R.string.no_network_available))
            }
            else -> {
                Resource.Error(message = context.getString(R.string.something_went_wrong))
            }
        }
    }

    private fun <T> mapHttpException(exception: HttpException): Resource<T> {
        return try {
            val httpCode = exception.code()
            val errorBody = exception.response()?.errorBody()?.string()
            if (errorBody != null) {
                Resource.Error(message = errorBody, httpCode = httpCode)
            } else {
                Resource.Error(message = context.getString(R.string.something_went_wrong), httpCode = httpCode)
            }
        } catch (parseException: Exception) {
            val httpCode = exception.code()
            Resource.Error(message = context.getString(R.string.something_went_wrong), httpCode = httpCode)
        }
    }

    companion object {
        private val TAG = NetworkExceptionHandler::class.simpleName
    }
}