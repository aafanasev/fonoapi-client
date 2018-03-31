package com.aafanasev.fonoapi.rxjava

import com.aafanasev.fonoapi.URL_BASE
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FonoApiFactory {

    @JvmOverloads
    fun create(okHttpClient: OkHttpClient? = null): FonoApiService = run {
        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())

        okHttpClient?.let {
            retrofitBuilder.client(okHttpClient)
        }

        retrofitBuilder.build().create(FonoApiService::class.java)
    }

}