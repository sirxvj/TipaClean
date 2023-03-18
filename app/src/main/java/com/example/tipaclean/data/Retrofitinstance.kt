package com.example.tipaclean.data

import com.example.tipaclean.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitinstance {
    private val retrofit by lazy{
        Retrofit.Builder().baseUrl("https://iis.bsuir.by/api/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }
    val api: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}