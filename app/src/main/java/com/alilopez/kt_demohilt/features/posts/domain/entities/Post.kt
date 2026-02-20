package com.alilopez.kt_demohilt.features.posts.domain.entities

/**
 * Entidad pura de dominio. Representa un Post de JSON Placeholder.
 */
data class Post(
    val id: Int,
    val title: String,
    val body: String
)