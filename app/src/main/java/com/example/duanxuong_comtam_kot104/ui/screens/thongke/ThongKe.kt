package com.example.comtam_kotlin_room.ui.screen.thongke


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.comtam_kotlin_room.utils.Route

data class ListItem(val id:String,val date: String, val description: String, val price:String,val our:String)

@Composable
fun ThongKe(navHostController: NavHostController) {

    // Danh sách các mục để hiển thị
    val itemsList = listOf(
        ListItem(" KD2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),
        ListItem(" ID2E22E", "03/03/2024", "Hoàn Thành","58k","9:30"),


        )

    // Sử dụng LazyColumn để hiển thị danh sách


    Column(  modifier = Modifier
        .fillMaxSize()
        .background(Color(0xff252121)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp) // Adjust spacing as needed
        ) {
            Button(
                onClick = {  navHostController.navigate(Route.THONGKE.screen)},
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxSize(0.5f),
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                shape = RoundedCornerShape(4.dp), // Smaller corner radius for less rounding
            ) {
                Text(text = "Doanh Thu", style = MaterialTheme.typography.titleMedium, color = Color.Yellow)
            }

            Button(
                onClick = {
                   navHostController.navigate(Route.BieuDo.screen)
                },
                modifier = Modifier

                    .height(40.dp)
                    .fillMaxSize(),

                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                shape = RoundedCornerShape(4.dp), // Smaller corner radius for less rounding
            ) {
                Text(text = "Biểu Đồ", style = MaterialTheme.typography.titleMedium,

                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Card(
                border = BorderStroke(1.5.dp, Color.Black),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(40.dp)
                    .padding(start = 30.dp, end = 40.dp)
                    .fillMaxWidth(0.3f),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) ,

                )  {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize().background(Color.DarkGray)
                ) {
                    Text(
                        text = "Từ Ngày",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,

                    )
                }
            }

            Card(
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.5.dp, Color.Black),
                modifier = Modifier
                    .height(40.dp)
                    .padding(end = 20.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) ,

                )  {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize().background(Color.DarkGray)
                ) {
                    Text(
                        text = "03/03/2024",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.fillMaxSize().padding(top = 10.dp, start = 10.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Card(
                border = BorderStroke(1.5.dp, Color.Black),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(40.dp)
                    .padding(start = 30.dp, end = 40.dp)
                    .fillMaxWidth(0.3f),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) ,

                )  {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize().background(Color.DarkGray)
                ) {
                    Text(
                        text = "Đến Ngày",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,

                        )
                }
            }

            Card(
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.5.dp, Color.Black),
                modifier = Modifier
                    .height(40.dp)
                    .padding(end = 20.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) ,

                )  {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize().background(Color.DarkGray)
                ) {
                    Text(
                        text = "03/03/2024",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.fillMaxSize().padding(top = 10.dp, start = 10.dp)
                    )
                }
            }
        }





        LazyColumn(
            modifier = Modifier
                .padding(top = 7.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize()
                .background(Color(0xff252121))
        )
        {
            items(itemsList) { item ->
                ListItemView(item = item,navHostController=navHostController)
            }
        }
    }


}

@Composable
fun ListItemView(item: ListItem,navHostController: NavHostController) {

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(top = 10.dp)
            .height(110.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) ,

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray) // Màu nền của Card

        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        ,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.id,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,

                    )
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.padding(end = 10.dp, bottom = 5.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.date,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                    )
                    Text(
                        text = item.price,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFFF8C00),
                        modifier = Modifier.padding(end = 70.dp)
                    )
                }
                Text(
                    text = item.our,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFFFF8C00),
                    modifier = Modifier.padding(top = 5.dp, start = 5.dp)
                )
            }
        }
    }
}
@Composable

fun TKScreenPreview() {
    ThongKe(navHostController = rememberNavController())
}



