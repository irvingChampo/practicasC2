package com.alilopez.kt_demohilt.features.posts.di

import com.alilopez.kt_demohilt.core.di.JsonPlaceHolderRetrofit
import com.alilopez.kt_demohilt.core.network.PostApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostNetworkModule {

    @Provides
    @Singleton
    fun providePostApi(
        // Aquí le decimos que use el Retrofit que tiene el Qualifier de JSON Placeholder
        @JsonPlaceHolderRetrofit retrofit: Retrofit
    ): PostApi {
        return retrofit.create(PostApi::class.java)
    }
}