package com.alilopez.kt_demohilt.features.posts.data.repositories

// IMPORTANTE: Importamos la API desde el paquete core.network
import com.alilopez.kt_demohilt.core.network.PostApi
import com.alilopez.kt_demohilt.features.posts.data.datasources.remote.mapper.toDomain
import com.alilopez.kt_demohilt.features.posts.domain.entities.Post
import com.alilopez.kt_demohilt.features.posts.domain.repositories.PostRepository
import jakarta.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        return api.getPosts().map { it.toDomain() }
    }
}