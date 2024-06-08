package com.example.comtam_kotlin_room.utils

sealed class Route(val screen: String) {
    data object Home : Route("Home")
    data object DetailCart : Route("Detail")
    data object Welcome : Route("Welcome")
    data object Login : Route("Login")
    data object Manage : Route("Manage")
    data object THONGKE : Route("THONGKE")
    data object Support : Route("Support")
    data object CategoryScreen : Route("Category")
    object Dish : Route("Dish")
    data object BieuDo : Route("bieudo")
}