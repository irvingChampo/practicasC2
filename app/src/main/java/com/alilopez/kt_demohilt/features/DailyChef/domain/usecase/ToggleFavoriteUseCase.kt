package com.alilopez.kt_demohilt.features.dailychef.domain.usecase

import com.alilopez.kt_demohilt.features.DailyChef.domain.repositories.FavoritesRepository
import jakarta.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {
    suspend operator fun invoke(recipeId: String) {
        repository.toggleFavorite(recipeId)
    }
}