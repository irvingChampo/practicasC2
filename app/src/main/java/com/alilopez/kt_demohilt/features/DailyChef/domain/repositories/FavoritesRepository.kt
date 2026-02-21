package com.alilopez.kt_demohilt.features.dailychef.domain.repositories

import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getFavoriteIds(): Flow<Set<String>>

    suspend fun toggleFavorite(recipeId: String)
}