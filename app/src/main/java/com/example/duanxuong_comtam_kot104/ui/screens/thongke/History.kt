package com.example.comtam_kotlin_room.ui.screen.thongke


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comtam_kotlin_room.utils.Route
data class ListTK(val time:String,val description:String)
@Preview
@Composable
fun History() {
    val itemTK = listOf(
        ListTK("21/03/2024", "Đơn hàng đã Từ chối"),
        ListTK("21/03/2024", "Đơn hàng đã Chấp nhận"),
        ListTK("21/03/2024", "Đơn hàng đã Từ chối"),
        ListTK("21/03/2024", "Đơn hàng đã Chấp nhận"),
        ListTK("21/03/2024", "Đơn hàng đã Chấp nhận"),
        ListTK("21/03/2024", "Đơn hàng đã Từ chối"),
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {}
    LazyColumn(
        modifier = Modifier
            .padding(top = 7.dp)
            .fillMaxSize()
            .background(Color.Black)
    )
    {
        items(itemTK) { item ->
            ListItemViewTK(item = item)
        }
    }
}

@Composable
fun ListItemViewTK(item: ListTK) {
    Card(
        shape = RoundedCornerShape(40.dp),
        modifier = Modifier
            .padding(start = 20.dp, bottom = 10.dp, top = 10.dp)
            .width(366.dp)
            .height(76.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) ,
//        colors = CardDefaults.cardColors(containerColor = Color(0x2F2D2D))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff252121)) // Màu nền của Card

        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Red,
                        modifier = Modifier.padding(start = 20.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "3 món",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.padding(end = 15.dp, bottom = 4.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text =item.time,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                    Text(
                        text = "9:20",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier
                            .padding(end = 70.dp)

                    )
                    Text(
                        text = "98 k",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier.padding(end = 30.dp)
                    )
                }
            }
        }
    }
}