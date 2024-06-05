package com.example.duanxuong_comtam_kot104.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.duanxuong_comtam_kot104.R
import com.example.duanxuong_comtam_kot104.navigation.BottomNavigationBar
import org.xmlpull.v1.sax2.Driver

@Composable
fun HomeAdminScreen(navController: NavHostController, selectedTab: Int, onTabSelected: (Int) -> Unit) {
    val innerNavController = rememberNavController()
    var selectedTab by remember { mutableIntStateOf(0) }
    val titles = listOf("Make home", "Statistics", "Manage", "Support")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF282222)) // Background color
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF282222)) // Background color
                .padding(16.dp)
        ){
            Header()
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp),
            color = Color.Black
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF282222)) // Background color
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Statistics()
            Spacer(modifier = Modifier.height(16.dp))
            OrdersList()
        }
        Spacer(modifier = Modifier.weight(1f))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp),
            color = Color.Black
        )
        BottomNavigationBar(selectedTab = selectedTab, onTabSelected = onTabSelected)
    }

}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.logosplash), // Replace with your profile icon
                contentDescription = "Profile",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Cum tấm dim",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            imageVector = Icons.Filled.Notifications,
            contentDescription = "Notifications",
            modifier = Modifier.size(24.dp),
            tint = Color.Yellow
        )
    }
}

@Composable
fun Statistics() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Today: 19-05-2023",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Số lượng đơn: 2",
            color = Color.White,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Doanh thu : 320.000 đ",
            color = Color.Red,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun OrdersList() {
    Column {
        OrderItem(orderId = "CT2E22E", amount = "162.000 đ", status = "Từ chối")
        OrderItem(orderId = "CT2E206", amount = "157.000 đ", status = "Từ chối")
        OrderItem(orderId = "CT2E23E", amount = "160.000 đ", status = "Chấp nhận")
        OrderItem(orderId = "CT2E12E", amount = "160.000 đ", status = "Chấp nhận")
    }
}

@Composable
fun OrderItem(orderId: String, amount: String, status: String) {
    val statusColor = if (status == "Chấp nhận") Color.Red else Color.Gray
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp)
            .background(Color.DarkGray, shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Đơn hàng $orderId",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = amount,
                color = Color.White,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Trạng thái",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = status,
                color = statusColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}
