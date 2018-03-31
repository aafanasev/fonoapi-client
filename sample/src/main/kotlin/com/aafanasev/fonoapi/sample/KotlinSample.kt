@file:JvmName("KotlinSample")

package com.aafanasev.fonoapi.sample

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import com.aafanasev.fonoapi.retrofit.FonoApiFactory as RetrofitFonoApiFactory
import com.aafanasev.fonoapi.rxjava.FonoApiFactory as ReactiveFonoApiFactory

// TODO: https://fonoapi.freshpixl.com/token/generate
const val token = ""

val okHttpClient: OkHttpClient by lazy {
    val logger = HttpLoggingInterceptor()
    logger.level = Level.BASIC

    OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
}

fun main(args: Array<String>) {
    showcaseRetrofit()
    showcaseRxJava()
}

fun showcaseRetrofit() {
    println("-- showcaseRetrofit --")

    val fonoApi = RetrofitFonoApiFactory().create(okHttpClient)

    val response = fonoApi.getLatest(token, "google").execute()
    response.body()?.forEach {
        println(it.deviceName)
    }
}

fun showcaseRxJava() {
    println("-- showcaseRxJava --")

    val fonoApi = ReactiveFonoApiFactory().create(okHttpClient)

    val response = fonoApi.getDevice(token, "pixel").blockingGet()
    response.forEach {
        println(it.deviceName)
    }
}
