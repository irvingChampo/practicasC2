package com.alilopez.kt_demohilt.features.posts.di

import com.alilopez.kt_demohilt.features.posts.data.repositories.PostRepositoryImpl
import com.alilopez.kt_demohilt.features.posts.domain.repositories.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PostModule {

    @Binds
    @Singleton
    abstract fun bindPostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository
}