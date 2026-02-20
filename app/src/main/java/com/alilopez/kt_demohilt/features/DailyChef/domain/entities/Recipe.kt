package com.alilopez.kt_demohilt.features.dailychef.domain.entities

data class Recipe(
    val id: String,
    val name: String,
    val imageUrl: String,
    val category: String = "",
    val instructions: String = "",
    val ingredients: List<String> = emptyList()
)