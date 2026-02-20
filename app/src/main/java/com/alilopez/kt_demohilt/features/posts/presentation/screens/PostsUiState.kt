package com.alilopez.kt_demohilt.features.posts.presentation.screens

import com.alilopez.kt_demohilt.features.posts.domain.entities.Post

/**
 * Representa el estado único de la pantalla de Posts.
 */
data class PostsUiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null
)