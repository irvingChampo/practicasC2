package com.alilopez.kt_demohilt.features.posts.data.datasources.remote.mapper

import com.alilopez.kt_demohilt.features.posts.data.datasources.remote.model.PostDto
import com.alilopez.kt_demohilt.features.posts.domain.entities.Post

/**
 * Mapea un PostDto (Data) a un Post (Domain).
 */
fun PostDto.toDomain(): Post {
    return Post(
        id = this.id,
        title = this.title,
        body = this.body
    )
}