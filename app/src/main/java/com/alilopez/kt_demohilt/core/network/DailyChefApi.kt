package com.alilopez.kt_demohilt.core.network

import com.alilopez.kt_demohilt.features.dailychef.data.datasources.remote.model.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DailyChefApi {
    @GET("filter.php")
    suspend fun getRecipesByCategory(@Query("c") category: String): RecipeResponse

    @GET("lookup.php")
    suspend fun getRecipeDetails(@Query("i") id: String): RecipeResponse
}