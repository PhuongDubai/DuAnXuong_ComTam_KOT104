package com.example.duanxuong_comtam_kot104.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.comtam_kotlin_room.utils.Route
import com.example.duanxuong_comtam_kot104.R

data class ListItem(val title: String, val description: String, val price: String)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAdminScreen(navigationController: NavHostController) {
    Scaffold(
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
    ) {
        val itemsList = listOf(
            ListItem("Đơn hàng CT2E22E", "Từ chối", "100.000 đ"),
            ListItem("Đơn hàng CT2E2206", "Chấp nhận", "500.000 đ"),
            ListItem("Đơn hàng CT2E23E", "Từ chối", "100.800 đ"),
            ListItem("Đơn hàng CT2E12E", "Từ chối", "101.854 đ"),
            ListItem("Đơn hàng CT2E12E", "Từ chối", "101.854 đ"),
            ListItem("Đơn hàng CT2E12E", "Từ chối", "101.854 đ"),
            ListItem("Đơn hàng CT2E12E", "Từ chối", "101.854 đ"),
            ListItem("Đơn hàng CT2E12E", "Từ chối", "101.854 đ"),
            ListItem("Đơn hàng CT2E12E", "Từ chối", "101.854 đ"),
            ListItem("Đơn hàng CT2E12E", "Từ chối", "101.854 đ"),

            )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff252121)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Today:23-09-2024 ",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Số lượng đơn: 1",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
            )
            Text(
                text = "Doanh thu: 500.000 đ",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
            )
            LazyColumn(
                modifier = Modifier
                    .padding(top = 7.dp, start = 16.dp, end = 16.dp)
                    .fillMaxSize()
                    .background(Color(0xff252121))
            )
            {
                items(itemsList) { item ->
                    ListItemView(item = item, navigationController = navigationController)
                }
            }
        }
    }
}

@Composable
fun ListItemView(item: ListItem, navigationController: NavHostController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(top = 10.dp)
            .clickable { navigationController.navigate(Route.DetailCart.screen) }
            .height(110.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        colors = CardDefaults.cardColors(containerColor = Color(0x2F2D2D))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray) // Màu nền của Card

        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                    )
                    Text(
                        text = "||",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .clickable {
                                navigationController.navigate(Route.DetailCart.screen)
                            }
                    )
                    Text(
                        text = item.price,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.padding(end = 10.dp, bottom = 10.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Trạng Thái",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                    )
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Red,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                }
            }
        }
    }
}
