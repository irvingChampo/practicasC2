package com.alilopez.kt_demohilt.features.posts.data.datasources.remote.model

/**
 * Data Transfer Object (DTO) para la API de JSON Placeholder.
 */
data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)