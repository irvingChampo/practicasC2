package com.alilopez.kt_demohilt.features.dailychef.domain.usecases

import com.alilopez.kt_demohilt.features.dailychef.domain.repositories.DailyChefRepository
import com.alilopez.kt_demohilt.features.dailychef.domain.entities.Recipe
import javax.inject.Inject

class GetRecipesByCategoryUseCase @Inject constructor(
    private val repository: DailyChefRepository
) {
    suspend operator fun invoke(category: String): Result<List<Recipe>> {
        return try {
            val recipes = repository.getRecipesByCategory(category)
            if (recipes.isEmpty()) Result.failure(Exception("No se encontraron recetas"))
            else Result.success(recipes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}