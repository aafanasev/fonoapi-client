@file:JvmName("KotlinSample")

package com.aafanasev.fonoapi.sample

import com.aafanasev.fonoapi.DeviceEntity
import com.aafanasev.fonoapi.FonoApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: https://fonoapi.freshpixl.com/token/generate
const val token = ""

fun main(args: Array<String>) {

    val fonoApi = FonoApiFactory().create()

    fonoApi.getLatest(token, "google").enqueue(object : Callback<List<DeviceEntity>> {
        override fun onResponse(call: Call<List<DeviceEntity>>, response: Response<List<DeviceEntity>>) {
            response.body()?.forEach {
                println(it.deviceName)
            }
        }

        override fun onFailure(call: Call<List<DeviceEntity>>, t: Throwable) = t.printStackTrace()

    })

}