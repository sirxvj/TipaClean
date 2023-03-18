package com.example.tipaclean.di

import android.provider.SyncStateContract.Constants
import com.example.tipaclean.common.constants
import com.example.tipaclean.data.remote.ApiService
import com.example.tipaclean.data.repository.RepositoryIMPL
import com.example.tipaclean.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
object AppModule {

//    @Provides
//    @Singleton
//    fun provideApi(): ApiService{
//        return Retrofit.Builder()
//            .baseUrl(constants.BASEURL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build().create(ApiService::class.java)
//    }
//    @Provides
//    @Singleton
//    fun provideRepository(api:ApiService):Repository{
//        return RepositoryIMPL(api)
//    }
}