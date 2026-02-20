package com.alilopez.kt_demohilt.features.posts.domain.usecases

import com.alilopez.kt_demohilt.features.posts.domain.entities.Post
import com.alilopez.kt_demohilt.features.posts.domain.repositories.PostRepository
import jakarta.inject.Inject

/**
 * Caso de uso para obtener los posts.
 * Aplica lógica de negocio adicional si es necesario (filtrados, validaciones).
 */
class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(): Result<List<Post>> {
        return try {
            val posts = repository.getPosts()

            // Lógica de negocio: Validamos que no venga vacío
            if (posts.isEmpty()) {
                Result.failure(Exception("No se encontraron publicaciones disponibles."))
            } else {
                // Podríamos filtrar datos aquí si el profesor lo requiere
                Result.success(posts)
            }
        } catch (e: Exception) {
            // Encapsulamos el error para la capa de presentación
            Result.failure(e)
        }
    }
}