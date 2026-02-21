package com.alilopez.kt_demohilt.features.dailychef.domain.usecases

import com.alilopez.kt_demohilt.features.dailychef.domain.repositories.DailyChefRepository
import com.alilopez.kt_demohilt.features.dailychef.domain.entities.Recipe
import jakarta.inject.Inject

class GetRecipeDetailsUseCase @Inject constructor(
    private val repository: DailyChefRepository
) {
    suspend operator fun invoke(recipeId: String): Result<Recipe> {
        return try {
            val recipe = repository.getRecipeById(recipeId)
            if (recipe != null) {
                Result.success(recipe)
            } else {
                Result.failure(Exception("No se pudo cargar el detalle de la receta"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}