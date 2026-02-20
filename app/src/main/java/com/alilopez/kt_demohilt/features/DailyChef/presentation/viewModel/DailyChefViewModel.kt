package com.alilopez.kt_demohilt.features.dailychef.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alilopez.kt_demohilt.features.dailychef.domain.usecase.GetFavoriteIdsUseCase
import com.alilopez.kt_demohilt.features.dailychef.domain.usecase.GetRecipeDetailsUseCase
import com.alilopez.kt_demohilt.features.dailychef.domain.usecase.GetRecipesByCategoryUseCase
import com.alilopez.kt_demohilt.features.dailychef.domain.usecase.ToggleFavoriteUseCase
import com.alilopez.kt_demohilt.features.dailychef.presentation.screens.DailyChefUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import jakarta.inject.Inject

@HiltViewModel
class DailyChefViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesByCategoryUseCase,
    private val getDetailsUseCase: GetRecipeDetailsUseCase,
    private val getFavoriteIdsUseCase: GetFavoriteIdsUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DailyChefUiState())
    val uiState = _uiState.asStateFlow()

    init {
        observeFavorites()
        loadRecipes(_uiState.value.currentCategory)
    }

    private fun observeFavorites() {
        viewModelScope.launch {
            getFavoriteIdsUseCase().collect { ids ->
                _uiState.update { it.copy(favoriteIds = ids) }
            }
        }
    }

    fun loadRecipes(category: String) {
        _uiState.update { it.copy(isLoading = true, currentCategory = category, selectedRecipe = null) }
        viewModelScope.launch {
            val result = getRecipesUseCase(category)
            _uiState.update { state ->
                result.fold(
                    onSuccess = { list -> state.copy(isLoading = false, recipes = list, error = null) },
                    onFailure = { err -> state.copy(isLoading = false, error = err.message) }
                )
            }
        }
    }

    fun onToggleFavorite(recipeId: String) {
        viewModelScope.launch {
            toggleFavoriteUseCase(recipeId)
        }
    }

    fun toggleFilterFavorites() {
        _uiState.update { it.copy(showFavoritesOnly = !it.showFavoritesOnly) }
    }

    fun getRecipeById(recipeId: String) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = getDetailsUseCase(recipeId)
            _uiState.update { state ->
                result.fold(
                    onSuccess = { recipe -> state.copy(isLoading = false, selectedRecipe = recipe) },
                    onFailure = { err -> state.copy(isLoading = false, error = err.message) }
                )
            }
        }
    }
}