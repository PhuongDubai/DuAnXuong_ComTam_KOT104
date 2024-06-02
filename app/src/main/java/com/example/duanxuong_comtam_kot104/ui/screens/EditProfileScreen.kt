package com.example.duanxuong_comtam_kot104.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duanxuong_comtam_kot104.R

@Preview(showBackground = true)
@Composable
fun EditProfileScreen() {

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Hồ sơ",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.W900
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Edit",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W900
                )
                Text(
                    text = "Signout",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W900
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(color = Color(0xFF252121)),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.anhlogo),
                    contentDescription = "anh logo",
                    modifier = Modifier
                        .offset(y=-50.dp)
                        .size(100.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(color = Color.White)

                )
                // Nội dung của Box ở đây
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 80.dp)
                ) {

                    Text(
                        text = "Họ và Tên",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(start = 20.dp),
                    )
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Phước", color = Color.Black) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(40.dp),
                        enabled = false
                    )
                    Text(
                        text = "Số điện thoại",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(start = 20.dp),
                    )
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("0888898680", color = Color.Black) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(40.dp),
                        enabled = false
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Phường",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(start = 20.dp),
                    )
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Trung Mỹ Tây", color = Color.Black) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(40.dp),
                        enabled = false
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Đường",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(start = 20.dp),
                    )
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Đường Tô ký", color = Color.Black) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(40.dp),
                        enabled = false
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Số nhà",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(start = 20.dp),
                    )
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("413", color = Color.Black) },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .height(40.dp),
                        enabled = false
                    )
                }


            }
            // Thêm các phần tử khác của Column ở đây


        }


    }
}