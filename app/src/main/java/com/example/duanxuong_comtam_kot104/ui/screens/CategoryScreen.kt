package com.example.duanxuong_comtam_kot104.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.duanxuong_comtam_kot104.R
import com.example.duanxuong_comtam_kot104.model.LoaiSanphamViewModel
import com.example.duanxuong_comtam_kot104.model.entities.LoaiSanphamDB
import com.example.duanxuong_comtam_kot104.model.entities.LoaiSanphamEntity
import com.example.duanxuong_comtam_kot104.repository.Repository

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(navController: NavController,viewModel: LoaiSanphamViewModel) {
    var inputTenloai by remember { mutableStateOf("") }
    val emty by remember { mutableStateOf("") }
    val showDialog = remember { mutableStateOf(false) }
    val loaisp by viewModel.loaisanphams.collectAsState(initial = emptyList())

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
                actions = {
                    IconButton(onClick = { /* Handle add icon click */ }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF252121),
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
                Box(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxSize()
                        .background(color = Color(0xFF252121)),
                ) {
                    if (loaisp.isEmpty()) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(paddingValues)
                                .fillMaxSize()
                                .background(Color(0xFF282222))
                        ) {
                            Text(text = "No name available")
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFF282222)),
                            contentPadding = PaddingValues(10.dp)
                        ) {
                            items(loaisp) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { }
                                        .padding(10.dp)
                                        .height(82.dp)
                                        .background(
                                            Color("#2B2929".toColorInt()),
                                            shape = RoundedCornerShape(10.dp)
                                        ),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text("${it.uid}", color = Color.White, fontSize = 20.sp)
                                    Spacer(modifier = Modifier.width(20.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            "${it.tenLoaiSp}",
                                            color = Color.White,
                                            fontSize = 20.sp
                                        )
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.img_edit),
                                        contentDescription = "ImageEdit",
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clickable { }
                                    )
                                    Spacer(modifier = Modifier.width(25.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.img_delete),
                                        contentDescription = "ImageDelete",
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clickable { }
                                    )
                                    Spacer(modifier = Modifier.width(25.dp))
                                }
                            }
                        }
                    }

                    if (showDialog.value) {
                        AlertDialog(
                            onDismissRequest = { showDialog.value = false },
                            dismissButton = {
                                Button(
                                    onClick = {
                                        showDialog.value = false
                                        inputTenloai = emty
                                    }
                                ) {
                                    Text(text = "Cancel")
                                }
                            },
                            confirmButton = {
                                if (inputTenloai.isNotEmpty()) {
                                    Button(
                                        onClick = {
                                            viewModel.addLoaiSanpham(
                                                LoaiSanphamEntity(
                                                    0,
                                                    inputTenloai,
                                                )
                                            )
                                            showDialog.value = false
                                            inputTenloai = emty
                                        }
                                    ) {
                                        Text(text = "Save")
                                    }
                                }
                            },
                            title = {
                                Text(
                                    text = "Add Student",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 25.sp,
                                    modifier = Modifier.padding(5.dp)
                                )
                            },
                            text = {
                                Column {
                                    OutlinedTextField(
                                        value = inputTenloai,
                                        onValueChange = { inputTenloai = it },
                                        label = {
                                            Text(text = "Họ Tên")
                                        },
                                        placeholder = { Text(text = "Nhập Họ Tên") }
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    )
}
