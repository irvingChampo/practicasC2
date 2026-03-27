package com.alilopez.kt_demohilt.core.navigation

sealed class Screen(val route: String) {

    // Pantalla de la feature "posts"
    object Posts : Screen("posts_screen")

    // Pantallas de la feature "dailychef"
    object RecipeList : Screen("recipe_list_screen")

    // Pantalla de detalle que recibe un argumento (recipeId)
    object RecipeDetail : Screen("recipe_detail_screen/{recipeId}") {
        fun createRoute(recipeId: String) = "recipe_detail_screen/$recipeId"
    }

}