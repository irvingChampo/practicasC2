package com.alilopez.kt_demohilt.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alilopez.kt_demohilt.features.dailychef.presentation.screens.RecipeDetailScreen
import com.alilopez.kt_demohilt.features.dailychef.presentation.screens.RecipeListScreen
import com.alilopez.kt_demohilt.features.dailychef.presentation.viewmodel.DailyChefViewModel
import com.alilopez.kt_demohilt.features.posts.presentation.screens.PostsScreen
import com.alilopez.kt_demohilt.features.posts.presentation.viewmodels.PostsViewModel

@Composable
fun DailyChefNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.RecipeList.route
    ) {

        composable(route = Screen.RecipeList.route) {
            val viewModel: DailyChefViewModel = hiltViewModel()
            RecipeListScreen(
                viewModel = viewModel,
                onRecipeClick = { id ->
                    navController.navigate(Screen.RecipeDetail.createRoute(id))
                },
                onPostsClick = {
                    navController.navigate(Screen.Posts.route)
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

        composable(route = Screen.Posts.route) {
            val postsViewModel: PostsViewModel = hiltViewModel()
            PostsScreen(viewModel = postsViewModel)
        }
    }
}