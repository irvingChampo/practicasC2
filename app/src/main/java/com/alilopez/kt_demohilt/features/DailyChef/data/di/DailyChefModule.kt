package com.alilopez.kt_demohilt.features.dailychef.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.alilopez.kt_demohilt.core.di.MealDbRetrofit
import com.alilopez.kt_demohilt.features.dailychef.data.datasources.remote.api.DailyChefApi
import com.alilopez.kt_demohilt.features.dailychef.data.repositories.DailyChefRepositoryImpl
import com.alilopez.kt_demohilt.features.dailychef.data.repositories.FavoritesRepositoryImpl
import com.alilopez.kt_demohilt.features.dailychef.domain.repositories.DailyChefRepository
import com.alilopez.kt_demohilt.features.dailychef.domain.repositories.FavoritesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

// Definición del DataStore
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "favorites_prefs")

@Module
@InstallIn(SingletonComponent::class)
abstract class DailyChefRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindDailyChefRepository(
        dailyChefRepositoryImpl: DailyChefRepositoryImpl
    ): DailyChefRepository

    @Binds
    @Singleton
    abstract fun bindFavoritesRepository(
        favoritesRepositoryImpl: FavoritesRepositoryImpl
    ): FavoritesRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DailyChefNetworkModule {

    @Provides
    @Singleton
    fun provideDailyChefApi(@MealDbRetrofit retrofit: Retrofit): DailyChefApi {
        return retrofit.create(DailyChefApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }
}