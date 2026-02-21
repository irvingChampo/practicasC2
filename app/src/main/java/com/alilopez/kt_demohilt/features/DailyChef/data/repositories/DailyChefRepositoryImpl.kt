package com.alilopez.kt_demohilt.features.dailychef.data.repositories

import com.alilopez.kt_demohilt.features.dailychef.data.datasources.remote.api.DailyChefApi
import com.alilopez.kt_demohilt.features.dailychef.data.datasources.remote.mapper.toDomain
import com.alilopez.kt_demohilt.features.dailychef.domain.entities.Recipe
import com.alilopez.kt_demohilt.features.dailychef.domain.repositories.DailyChefRepository
import javax.inject.Inject

class DailyChefRepositoryImpl @Inject constructor(
    private val api: DailyChefApi
) : DailyChefRepository {
    override suspend fun getRecipesByCategory(category: String): List<Recipe> {
        val response = api.getRecipesByCategory(category)
        return response.meals?.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun getRecipeById(id: String): Recipe? {
        val response = api.getRecipeDetails(id)
        return response.meals?.firstOrNull()?.toDomain()
    }
}