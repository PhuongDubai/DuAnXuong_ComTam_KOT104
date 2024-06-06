package com.example.duanxuong_comtam_kot104.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.core.graphics.toColorInt
import com.example.duanxuong_comtam_kot104.R

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color(0xFF282222)
    ) {
        val items = listOf("Trang chủ", "Thống kê", "Quản lý", "Hỗ trợ")
        val icons = listOf(
            Icons.Filled.Home,
            Icons.Filled.ShoppingCart,
            Icons.Filled.List,
            Icons.Filled.Person
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color("#999999".toColorInt()),
                    indicatorColor = Color.White
                )
            )
        }
    }
}

fun getRouteForIndex(index: Int): String {
    return when (index) {
        0 -> NavigationItem.Home.route
        1 -> NavigationItem.Statistics.route
        2 -> NavigationItem.Manage.route
        3 -> NavigationItem.Support.route
        else -> NavigationItem.Home.route
    }
}

sealed class NavigationItem(var route: String) {
    data object Home : NavigationItem("Home")
    data object Statistics : NavigationItem("Statistics")
    data object Manage : NavigationItem("Manage")
    data object Support : NavigationItem("Support")
}
