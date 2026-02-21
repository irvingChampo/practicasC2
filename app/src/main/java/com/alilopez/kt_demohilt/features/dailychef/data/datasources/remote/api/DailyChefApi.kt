package com.alilopez.kt_demohilt.features.dailychef.data.datasources.remote.api

import com.alilopez.kt_demohilt.features.dailychef.data.datasources.remote.models.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DailyChefApi {
    @GET("filter.php")
    suspend fun getRecipesByCategory(@Query("c") category: String): RecipeResponse

    @GET("lookup.php")
    suspend fun getRecipeDetails(@Query("i") id: String): RecipeResponse
}