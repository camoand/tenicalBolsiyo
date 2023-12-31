package com.example.pruebatecnicabolsiyo.core.network

import com.example.pruebatecnicabolsiyo.domain.Constans
import com.example.pruebatecnicabolsiyo.core.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideaApiClient(retrofit: Retrofit): ApiService{
       return retrofit.create(ApiService::class.java)
    }

}