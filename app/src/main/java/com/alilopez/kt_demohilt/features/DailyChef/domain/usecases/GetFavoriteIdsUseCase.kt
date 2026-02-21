package com.alilopez.kt_demohilt.features.dailychef.domain.usecases

import com.alilopez.kt_demohilt.features.dailychef.domain.repositories.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import jakarta.inject.Inject

class GetFavoriteIdsUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {
    operator fun invoke(): Flow<Set<String>> {
        return repository.getFavoriteIds()
    }
}