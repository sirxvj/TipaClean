package com.example.tipaclean.data.remote


import com.example.tipaclean.data.remote.dto.Prepod
import retrofit2.http.GET

interface ApiService {

    @GET("v1/employees/all")
    suspend fun getPrepods():List<Prepod>
}