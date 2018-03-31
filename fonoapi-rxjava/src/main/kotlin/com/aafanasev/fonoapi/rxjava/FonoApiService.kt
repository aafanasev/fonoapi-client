package com.aafanasev.fonoapi.rxjava

import com.aafanasev.fonoapi.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FonoApiService {

    @GET(URL_GET_DEVICE)
    fun getDevice(
            @Query(QUERY_TOKEN) token: String,
            @Query(QUERY_DEVICE) device: String,
            @Query(QUERY_BRAND) brand: String? = null,
            @Query(QUERY_POSITION) position: Int? = null
    ): Single<List<DeviceEntity>>

    @GET(URL_GET_LATEST)
    fun getLatest(
            @Query(QUERY_TOKEN) token: String,
            @Query(QUERY_BRAND) brand: String,
            @Query(QUERY_LIMIT) limit: Int? = null
    ): Single<List<DeviceEntity>>

}