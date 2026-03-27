package com.alilopez.kt_demohilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.alilopez.kt_demohilt.core.navigation.DailyChefNavGraph
import com.alilopez.kt_demohilt.core.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppTheme {
                // El NavController es el estado que recuerda en qué pantalla estamos
                val navController = rememberNavController()
                // Inyección del NavGraph global
                DailyChefNavGraph(navController = navController)
            }
        }
    }
}