package com.example.duanxuong_comtam_kot104.navigation

import ManagerScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.comtam_kotlin_room.utils.Route
import com.example.duanxuong_comtam_kot104.viewmodel.LoaiSanphamViewModel
import com.example.duanxuong_comtam_kot104.data.category.LoaiSanphamDB
import com.example.duanxuong_comtam_kot104.data.dish.DishDB
import com.example.duanxuong_comtam_kot104.repository.CategoryRepository
import com.example.duanxuong_comtam_kot104.repository.DishRepository
import com.example.duanxuong_comtam_kot104.ui.screens.CategoryScreen
import com.example.duanxuong_comtam_kot104.ui.screens.DetailsCart
import com.example.duanxuong_comtam_kot104.ui.screens.DishScreen
import com.example.duanxuong_comtam_kot104.ui.screens.LoginScreen
import com.example.duanxuong_comtam_kot104.ui.screens.ManagerCategoriesScreen
import com.example.duanxuong_comtam_kot104.ui.screens.RegisterScreen
import com.example.duanxuong_comtam_kot104.ui.screens.SplashScreen
import com.example.duanxuong_comtam_kot104.ui.screens.SuportScreen
import com.example.duanxuong_comtam_kot104.viewmodel.DishViewModel

@Composable
fun AppNavigation(navController: NavHostController) {
    val context = LocalContext.current
    val dbCategory = LoaiSanphamDB.getIntance(context)
    val categoryRepositoryCategory = CategoryRepository(dbCategory)
    val categoryViewModel = LoaiSanphamViewModel(categoryRepositoryCategory)
    val dbDish = DishDB.getIntance(context)
    val dishRepositoryCategory = DishRepository(dbDish)
    val dishViewModel = DishViewModel(dishRepositoryCategory)
    NavHost(navController = navController, startDestination = "Splash") {
        composable(route = "Splash") {
            SplashScreen(navController)
        }
        composable(route = "Login") {
            LoginScreen(navController,)
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
        composable(Route.CategoryScreen.screen) {
            CategoryScreen(navController, categoryViewModel)
        }
        composable(Route.Dish.screen) {
            DishScreen(navController, dishViewModel, categoryViewModel)
        }
        composable(route = "ManagerCategory") {
            ManagerCategoriesScreen(navController)
        }
        composable(route = "Detail") {
            DetailsCart(navController)
        }
    }
}

