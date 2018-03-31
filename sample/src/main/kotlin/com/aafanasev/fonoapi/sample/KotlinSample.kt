@file:JvmName("KotlinSample")

package com.aafanasev.fonoapi.sample

import com.aafanasev.fonoapi.DeviceEntity
import io.reactivex.functions.Consumer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.aafanasev.fonoapi.retrofit.FonoApiFactory as RetrofitFonoApiFactory
import com.aafanasev.fonoapi.rxjava.FonoApiFactory as ReactiveFonoApiFactory

// TODO: https://fonoapi.freshpixl.com/token/generate
const val token = ""

fun main(args: Array<String>) {
    showcaseRetrofit()
    showcaseRxJava()
}

fun showcaseRetrofit() {
    println("-- showcaseRetrofit --")

    val fonoApi = RetrofitFonoApiFactory().create()

    fonoApi.getLatest(token, "google").enqueue(object : Callback<List<DeviceEntity>> {
        override fun onResponse(call: Call<List<DeviceEntity>>, response: Response<List<DeviceEntity>>) {
            response.body()?.forEach {
                println(it.deviceName)
            }
        }

        override fun onFailure(call: Call<List<DeviceEntity>>, t: Throwable) = t.printStackTrace()

    })
}

fun showcaseRxJava() {
    println("-- showcaseRxJava --")

    val fonoApi = ReactiveFonoApiFactory().create()

    fonoApi.getDevice(token, "pixel").subscribe(Consumer {
        it.forEach {
            println(it.deviceName)
        }
    })

}
