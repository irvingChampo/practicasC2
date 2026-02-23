package com.alilopez.kt_demohilt.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alilopez.kt_demohilt.features.dailychef.presentation.screens.RecipeDetailScreen
import com.alilopez.kt_demohilt.features.dailychef.presentation.screens.RecipeListScreen
import com.alilopez.kt_demohilt.features.dailychef.presentation.viewmodel.DailyChefViewModel

@Composable
fun DailyChefNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.RecipeList.route
    ) {
        composable(route = Screen.RecipeList.route) {
            // hiltViewModel() automáticamente busca la factory generada por Hilt
            val viewModel: DailyChefViewModel = hiltViewModel()
            RecipeListScreen(
                viewModel = viewModel,
                onRecipeClick = { id ->
                    navController.navigate(Screen.RecipeDetail.createRoute(id))
                }
            )
        }

        composable(
            route = Screen.RecipeDetail.route,
            arguments = listOf(navArgument("recipeId") { type = NavType.StringType })
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId") ?: ""
            val viewModel: DailyChefViewModel = hiltViewModel()
            RecipeDetailScreen(
                recipeId = recipeId,
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}