package com.alilopez.kt_demohilt.core.network

import com.alilopez.kt_demohilt.features.posts.data.datasources.remote.model.PostDto
import retrofit2.http.GET

/**
 * Interfaz de Retrofit para JSON Placeholder.
 */
interface PostApi {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}