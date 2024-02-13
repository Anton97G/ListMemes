package com.example.listmemes.data

import retrofit2.http.GET

interface ApiService {


    @GET("get_memes")
    suspend fun getMemes():Data


}