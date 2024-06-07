package com.example.duanxuong_comtam_kot104.navigation

import ManagerScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.comtam_kotlin_room.utils.Route
import com.example.duanxuong_comtam_kot104.ui.screens.AddCategoriesScreen
import com.example.duanxuong_comtam_kot104.ui.screens.DetailsCart
import com.example.duanxuong_comtam_kot104.ui.screens.DishScreen
import com.example.duanxuong_comtam_kot104.ui.screens.LoginScreen
import com.example.duanxuong_comtam_kot104.ui.screens.ManagerCategoriesScreen
import com.example.duanxuong_comtam_kot104.ui.screens.RegisterScreen
import com.example.duanxuong_comtam_kot104.ui.screens.SplashScreen
import com.example.duanxuong_comtam_kot104.ui.screens.SuportScreen

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
        composable(route = "Home") {
            BottomNavigation(navController)
        }
        composable(route = "Manage") {
            ManagerScreen(navController)
        }
        composable(route = "Support") {
            SuportScreen(navController)
        }
        composable(Route.AddCategory.screen) { AddCategoriesScreen(navController) }
        composable(Route.Dish.screen) { DishScreen(navController) }
        composable(route = "ManagerCategory") {
            ManagerCategoriesScreen(navController)
        }
        composable(route = "Detail") {
            DetailsCart(navController)
        }
    }
}
