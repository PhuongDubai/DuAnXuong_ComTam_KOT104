package com.example.duanxuong_comtam_kot104.navigation

import ManagerScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comtam_kotlin_room.ui.screen.thongke.ThongKe
import com.example.comtam_kotlin_room.utils.Route
import com.example.duanxuong_comtam_kot104.R
import com.example.duanxuong_comtam_kot104.ui.screens.DetailsCart
import com.example.duanxuong_comtam_kot104.ui.screens.HomeAdminScreen
import com.example.duanxuong_comtam_kot104.ui.screens.SuportScreen

@Composable
fun BottomNavigation(navController: NavHostController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MyBottomAppBar(navController)
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar(navController: NavHostController) {
    val navigationController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    Scaffold (
        topBar = {

            Column(Modifier.fillMaxWidth()) {
                TopAppBar(
                    title = {
                        Row (modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription ="",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxWidth(0.12f)
                            )
                            Text(text = "Cum tứm đim")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xff252121),
                        titleContentColor = Color.White,
                    ),

                    )
                Divider(thickness = 2.dp, color = Color.Black)
            }

        },
        bottomBar = {
            Column(Modifier.fillMaxWidth()) {
                Divider(thickness = 2.dp, color = Color.Black)

                BottomAppBar(
                    containerColor = Color(0xFF312C2C)
                ) {
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Home
                            navigationController.navigate(Route.Home.screen){
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                    {
                        Icon( if (selected.value == Icons.Default.Home)  Icons.Default.Home  else  Icons.Outlined.Home,
                            contentDescription = "",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Rounded.ShoppingCart
                            navigationController.navigate(Route.THONGKE.screen){
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                    {
                        Icon(if (selected.value == Icons.Rounded.ShoppingCart) Icons.Rounded.ShoppingCart  else  Icons.Outlined.ShoppingCart,
                            contentDescription = "",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Rounded.Menu
                            navigationController.navigate(Route.Manage.screen){
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                    {
                        Icon(if (selected.value == Icons.Rounded.Menu) painterResource(id = R.drawable.shoppingmode_fill_24px) else painterResource(id = R.drawable.shoppingmode_24px),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Person
                            navigationController.navigate(Route.Support.screen){
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                    {
                        Icon(if (selected.value == Icons.Default.Person) Icons.Default.Person else Icons.Outlined.Person,
                            contentDescription = "",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                }
            }

        }
    )
    { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Route.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Route.Home.screen) { HomeAdminScreen(navigationController) }
            composable(Route.DetailCart.screen) { DetailsCart(navigationController) }
            composable(Route.THONGKE.screen) { ThongKe(navigationController) }
            composable(Route.Manage.screen) { ManagerScreen(navigationController) }
            composable(Route.Support.screen) { SuportScreen(navigationController) }
        }
    }
}
