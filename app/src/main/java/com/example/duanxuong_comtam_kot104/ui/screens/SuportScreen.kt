package com.example.duanxuong_comtam_kot104.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.duanxuong_comtam_kot104.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuportScreen(navController: NavController) {
    Scaffold(
        content = { paddingValues: PaddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = Color.Black),
            ) {
                // Your content goes here, for example:
                Box(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxSize()
                        .background(color = Color(0xFF252121)),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 100.dp),


                        ) {
                        Row(
                            modifier = Modifier.padding(bottom = 50.dp, start = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_zalo),
                                contentDescription = "zalo",
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(end = 8.dp)
                                    .fillMaxSize(0.5f)
                            )
                            Text(
                                text = "0888898680",
                                color = Color.White,
                                fontWeight = FontWeight.W700,
                                fontSize = 20.sp
                            )
                        }
                        Row(
                            modifier = Modifier.padding(bottom = 50.dp, start = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_email),
                                contentDescription = "email",
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(end = 8.dp)
                                    .fillMaxSize(0.5f)
                            )
                            Text(
                                text = "phuongncph30902@fpt.edu.vn",
                                color = Color.White,
                                fontWeight = FontWeight.W700,
                                fontSize = 20.sp
                            )
                        }
                        Row(
                            modifier = Modifier.padding(start = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_phone),
                                contentDescription = "phone",
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(end = 8.dp)
                                    .fillMaxSize(0.5f)
                            )
                            Text(
                                text = "0888898680",
                                color = Color.White,
                                fontWeight = FontWeight.W700,
                                fontSize = 20.sp
                            )
                        }

                    }
                }
            }
        }
    )
}
