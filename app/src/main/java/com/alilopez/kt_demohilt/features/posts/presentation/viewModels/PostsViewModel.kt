package com.alilopez.kt_demohilt.features.posts.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alilopez.kt_demohilt.features.posts.domain.usecases.GetPostsUseCase
import com.alilopez.kt_demohilt.features.posts.presentation.screens.PostsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import jakarta.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    // Variable privada para el estado (Encapsulamiento)
    private val _uiState = MutableStateFlow(PostsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getPostsUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(isLoading = false, posts = list, error = null)
                    },
                    onFailure = { exception ->
                        currentState.copy(isLoading = false, error = exception.message)
                    }
                )
            }
        }
    }
}