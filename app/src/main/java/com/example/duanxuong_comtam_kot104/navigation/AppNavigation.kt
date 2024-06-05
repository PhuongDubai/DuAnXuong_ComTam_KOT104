package com.example.duanxuong_comtam_kot104.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.duanxuong_comtam_kot104.ui.screens.HomeAdminScreen
import com.example.duanxuong_comtam_kot104.ui.screens.LoginScreen
import com.example.duanxuong_comtam_kot104.ui.screens.RegisterScreen
import com.example.duanxuong_comtam_kot104.ui.screens.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "Home") {

        composable(route = "Splash") {
            SplashScreen(navController)
        }

        composable(route = "Login") {
            LoginScreen(navController)
        }

        composable(route = "SignUp") {
            RegisterScreen(navController)
        }

        composable(route = "Home") { backStackEntry ->
            val selectedTab = backStackEntry.arguments?.getInt("selectedTab") ?: 0
            HomeAdminScreen(navController = navController, selectedTab = selectedTab, onTabSelected = { index ->
                navController.navigate(getRouteForIndex(index)) {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            })
        }

    }
}
