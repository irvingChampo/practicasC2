package com.alilopez.kt_demohilt.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Provee el Retrofit para la API de JsonPlaceHolder
     */
    @Provides
    @Singleton
    @JsonPlaceHolderRetrofit
    fun provideJsonPlaceHolderRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Provee el Retrofit para la API de DailyChef (TheMealDB)
     */
    @Provides
    @Singleton
    @MealDbRetrofit
    fun provideMealDbRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}