package com.alilopez.kt_demohilt.features.dailychef.domain.repositories

import com.alilopez.kt_demohilt.features.dailychef.domain.entities.Recipe

interface DailyChefRepository {
    suspend fun getRecipesByCategory(category: String): List<Recipe>

    suspend fun getRecipeById(id: String): Recipe?
}