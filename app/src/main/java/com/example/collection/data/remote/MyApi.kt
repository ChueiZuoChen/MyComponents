package com.example.collection.data.remote

import retrofit2.http.GET

/**
 * 這是Api call的介面，也就是定義Api的路由規範 @GET @POST @DELETE...
 * */
interface MyApi {
    @GET("test")
    suspend fun doNetworkCall()
}