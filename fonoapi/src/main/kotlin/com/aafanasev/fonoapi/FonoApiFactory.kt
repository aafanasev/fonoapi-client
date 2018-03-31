package com.aafanasev.fonoapi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FonoApiFactory {

    private companion object {
        private const val BASE_URL = "https://fonoapi.freshpixl.com/"
    }

    @JvmOverloads
    fun create(okHttpClient: OkHttpClient? = null): FonoApiService = run {
        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        okHttpClient?.let {
            retrofitBuilder.client(okHttpClient)
        }

        retrofitBuilder.build().create(FonoApiService::class.java)
    }

}