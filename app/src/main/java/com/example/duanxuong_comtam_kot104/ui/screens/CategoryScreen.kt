package com.example.duanxuong_comtam_kot104.ui.screens

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.duanxuong_comtam_kot104.R
import com.example.duanxuong_comtam_kot104.model.LoaiSanphamViewModel
import com.example.duanxuong_comtam_kot104.model.entities.LoaiSanphamDB
import com.example.duanxuong_comtam_kot104.model.entities.LoaiSanphamEntity
import com.example.duanxuong_comtam_kot104.repository.Repository


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(viewModel: LoaiSanphamViewModel) {
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
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF252121),  // Correctly use Color with hex value
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                )
            )
        },
    ) {

        if (loaisp.isEmpty()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .background(Color(0xFF282222))
                ) {
                    Text(text = "No name available")
                }
        } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .background(Color(0xFF282222)),
                    contentPadding = PaddingValues(10.dp)
                ) {
                    items(loaisp) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.Red)
                                .padding(5.dp),

                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(14.dp)
                                    .background(color = Color.Red)
                            ) {
                                Text(
                                    text = "ID: " + it.uid,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(5.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Họ tên: " + it.tenLoaiSp,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(5.dp),
                                )

                            }
                        }

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
                if (inputTenloai.isNotEmpty() ) {

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
                        onValueChange = {inputTenloai = it},
                        label = {
                            Text(text = "Họ Tên")
                        },
                        placeholder = { Text(text = "Nhập Họ Tên")}
                    )

                }
            }
        )
    }
}
@Preview (showBackground = true)
@Composable
fun previewCategory(){
    val context = LocalContext.current
    val db = LoaiSanphamDB.getIntance(context)
    val repository = Repository(db)
    val myViewModel = LoaiSanphamViewModel(repository)
    CategoryScreen(myViewModel)
}