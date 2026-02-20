package com.alilopez.kt_demohilt.features.posts.domain.repositories

import com.alilopez.kt_demohilt.features.posts.domain.entities.Post

/**
 * Definición del contrato para el manejo de Posts.
 * La implementación real estará en la capa de DATA.
 */
interface PostRepository {
    suspend fun getPosts(): List<Post>
}