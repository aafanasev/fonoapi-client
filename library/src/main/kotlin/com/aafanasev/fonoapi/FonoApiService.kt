package com.aafanasev.fonoapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FonoApiService {

    @GET("/v1/getdevice")
    fun getDevice(
            @Query("token") token: String,
            @Query("device") device: String,
            @Query("brand") brand: String? = null,
            @Query("position") position: Int? = null
    ): Call<List<DeviceEntity>>

    @GET("/v1/getlatest")
    fun getLatest(
            @Query("token") token: String,
            @Query("brand") brand: String,
            @Query("limit") limit: Int? = null
    ): Call<List<DeviceEntity>>

}