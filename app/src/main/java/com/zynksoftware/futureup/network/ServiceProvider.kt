package com.zynksoftware.futureup.network

import com.squareup.moshi.Moshi
import com.zynksoftware.futureup.BuildConfig
import com.zynkxsoftware.futureup.network.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceProvider(private val moshi: Moshi, private val okHttpClient: OkHttpClient) {

    fun createApiService(): ApiService {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))

        val retrofit = retrofitBuilder.client(okHttpClient).build()
        return retrofit.create(ApiService::class.java)
    }

}