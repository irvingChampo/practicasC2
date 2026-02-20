package com.alilopez.kt_demohilt.features.DailyChef.presentation.screens

import com.alilopez.kt_demohilt.features.dailychef.domain.entities.Recipe

data class DailyChefUiState(
    val isLoading: Boolean = false,
    val recipes: List<Recipe> = emptyList(),
    val favoriteIds: Set<String> = emptySet(),
    val showFavoritesOnly: Boolean = false,
    val selectedRecipe: Recipe? = null,
    val error: String? = null,
    val currentCategory: String = "Seafood"
) {
    val filteredRecipes: List<Recipe>
        get() = if (showFavoritesOnly) {
            recipes.filter { favoriteIds.contains(it.id) }
        } else {
            recipes
        }
}