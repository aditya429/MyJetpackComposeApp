package com.aditya.codingtestandroid.model

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesBaseUrl() = "https://bible-api.com"

    @Provides
    @Singleton
    fun provideRetrofit(BASEURL : String) : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesBibleApi(retrofit: Retrofit) : ApiService =
        retrofit.create(ApiService::class.java)
}