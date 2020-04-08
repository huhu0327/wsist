package com.huhu.wsist.api

import com.huhu.wsist.`interface`.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MusicAPI {
    fun get(): RetrofitService = retrofit.create(RetrofitService::class.java)

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.manana.kr")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}