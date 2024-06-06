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
import com.example.duanxuong_comtam_kot104.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Manager() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.anhlogo),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(60.dp)
                                .padding(end = 8.dp)
                                .fillMaxSize(0.5f)
                        )
                        Text(text = "Cum tứm đim")
                    }
                },


                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF252121),  // Correctly use Color with hex value
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                )
            )
        },
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
                    Column {
                        Row(
                            modifier = Modifier.padding(top=50.dp, start = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.anhlogo),
                                contentDescription = "Logo",
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(end = 8.dp)
                                    .fillMaxSize(0.5f)
                            )
                            Text(
                                text = "Quản lý loại món ăn",
                                color = Color.White,
                                fontWeight = FontWeight.W700
                            )
                        }
                        Row(
                            modifier = Modifier.padding(top=30.dp, start = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.anhlogo),
                                contentDescription = "Logo",
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(end = 8.dp)
                                    .fillMaxSize(0.5f)
                            )
                            Text(
                                text = "Quản lý món ăn",
                                color = Color.White,
                                fontWeight = FontWeight.W700
                            )
                        }

                    }
                }
            }
        }
    )
}
