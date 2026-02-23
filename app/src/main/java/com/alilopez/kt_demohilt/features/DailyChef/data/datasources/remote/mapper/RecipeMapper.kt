package com.alilopez.kt_demohilt.features.dailychef.data.datasources.remote.mapper

import com.alilopez.kt_demohilt.features.dailychef.data.datasources.remote.models.RecipeDto
import com.alilopez.kt_demohilt.features.dailychef.domain.entities.Recipe

fun RecipeDto.toDomain(): Recipe {
    val ingredientsList = listOfNotNull(
        strIngredient1, strIngredient2, strIngredient3,
        strIngredient4, strIngredient5, strIngredient6
    ).filter { it.isNotBlank() }

    return Recipe(
        id = this.id,
        name = this.name,
        imageUrl = this.imageUrl,
        category = this.category ?: "",
        instructions = this.instructions ?: "",
        ingredients = ingredientsList
    )
}