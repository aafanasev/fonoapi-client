package com.aafanasev.fonoapi.rxjava

import com.aafanasev.fonoapi.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FonoApiService {

    /**
     * Search devices
     *
     * @param token access token (required)
     * @param device search query, device name f.ex "k750i", "Nexus 4", etc (required)
     * @param brand brand name f.ex "Apple", "Samsung", etc (optional)
     * @param position position of device in result set (optional). If specified only 1 item will be returned
     */
    @GET(URL_GET_DEVICE)
    fun getDevice(
            @Query(QUERY_TOKEN) token: String,
            @Query(QUERY_DEVICE) device: String,
            @Query(QUERY_BRAND) brand: String? = null,
            @Query(QUERY_POSITION) position: Int? = null
    ): Single<List<DeviceEntity>>

    /**
     * Get the latest added devices
     *
     * @param token access token (required)
     * @param brand search query, brand name f.ex "Apple", "Samsung", etc (required)
     * @param limit limit the result count, max 100 (optional)
     */
    @GET(URL_GET_LATEST)
    fun getLatest(
            @Query(QUERY_TOKEN) token: String,
            @Query(QUERY_BRAND) brand: String,
            @Query(QUERY_LIMIT) limit: Int? = null
    ): Single<List<DeviceEntity>>

}