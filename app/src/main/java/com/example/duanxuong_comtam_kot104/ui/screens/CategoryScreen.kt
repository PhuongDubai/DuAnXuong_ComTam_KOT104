package com.example.duanxuong_comtam_kot104.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.duanxuong_comtam_kot104.R
import com.example.duanxuong_comtam_kot104.viewmodel.LoaiSanphamViewModel
import com.example.duanxuong_comtam_kot104.data.category.LoaiSanphamDB
import com.example.duanxuong_comtam_kot104.entities.category.LoaiSanphamEntity
import com.example.duanxuong_comtam_kot104.repository.CategoryRepository
import com.example.duanxuong_comtam_kot104.ui.components.MyToolbar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(navController: NavController, viewModel: LoaiSanphamViewModel, onBackClick: () -> Unit) {
    var inputTenloai by remember { mutableStateOf("") }
    val empty by remember { mutableStateOf("") }
    val loaisp by viewModel.loaisanphams.collectAsState(initial = emptyList())
    var showAddDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf<LoaiSanphamEntity?>(null) }

    Scaffold(
        topBar = {
            MyToolbar(
                title = "Danh sách loại ",
                onBackClick = onBackClick,
                onAddClick = {
                    showAddDialog=true;
                }
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
                        .background(Color(0xFF282222))
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
                            Text(text = "No name available", color = Color.White, fontSize = 20.sp)
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFF282222)),
                            contentPadding = PaddingValues(10.dp)
                        ) {
                            items(loaisp) { category ->
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
                                    Text("${category.uid}", color = Color.White, fontSize = 20.sp)
                                    Spacer(modifier = Modifier.width(20.dp))
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            "${category.tenLoaiSp}",
                                            color = Color.White,
                                            fontSize = 20.sp
                                        )
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.img_edit),
                                        contentDescription = "ImageEdit",
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clickable {
                                                selectedCategory = category
                                                inputTenloai = inputTenloai // Change this line
                                                showEditDialog = true
                                            }
                                    )
                                    Spacer(modifier = Modifier.width(25.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.img_delete),
                                        contentDescription = "ImageDelete",
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clickable {
                                                selectedCategory = category
                                                showDeleteDialog = true
                                            }
                                    )
                                    Spacer(modifier = Modifier.width(25.dp))
                                }
                            }
                        }
                    }

                    if (showAddDialog) {
                        AddLoaiDialog(
                            onDismiss = { showAddDialog = false },
                            onConfirm = {
                                viewModel.addLoaiSanpham(
                                    LoaiSanphamEntity(
                                        0,
                                        inputTenloai,
                                    )
                                )
                                showAddDialog = false
                                inputTenloai = empty
                            },
                            inputTenloai = inputTenloai,
                            onInputChange = { inputTenloai = it }
                        )
                    }

                    if (showEditDialog) {
                        EditLoaiDialog(
                            onDismiss = { showEditDialog = false },
                            onConfirm = {
                                selectedCategory?.let {
                                    viewModel.updateLoaiSanpham(
                                        it.copy(
                                            tenLoaiSp = inputTenloai
                                        )
                                    )
                                }
                                showEditDialog = false
                                inputTenloai = empty
                            },
                            inputTenloai = inputTenloai,
                            onInputChange = { inputTenloai = it }
                        )
                    }
                    if (showDeleteDialog) {
                        DeleteLoaiSanphamDialog(
                            onDismiss = { showDeleteDialog = false },
                            onConfirm = {
                                selectedCategory?.let { category ->
                                    viewModel.deleteLoaiSanpham(category)
                                }
                                showDeleteDialog = false // Dismiss dialog after deleting
                            }
                        )
                    }


                }
            }
        }
    )
}

@Composable
fun AddLoaiDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit,
    inputTenloai: String,
    onInputChange: (String) -> Unit
) {
    val context = LocalContext.current
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color("#221F1F".toColorInt()))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Category", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(5.dp)),
                    value = inputTenloai,
                    onValueChange = onInputChange,
                    placeholder = { Text(text = "Nhập Category") },
                )

                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = onDismiss,
                        modifier = Modifier.width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt()),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Hủy", fontSize = 14.sp)
                    }
                    Button(
                        onClick = {
                            if (inputTenloai.isEmpty()) {
                                Toast.makeText(context, "Vui lòng nhập Category", Toast.LENGTH_SHORT).show()
                            } else {
                                onConfirm(inputTenloai)
                                onDismiss()
                            }
                        },
                        modifier = Modifier.width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt()),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Xác nhận", fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun EditLoaiDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit,
    inputTenloai: String,
    onInputChange: (String) -> Unit
) {
    val context = LocalContext.current
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color("#221F1F".toColorInt()))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Category", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(5.dp)),
                    value = inputTenloai,
                    onValueChange = onInputChange,

                )

                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = onDismiss,
                        modifier = Modifier.width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt()),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Hủy", fontSize = 14.sp)
                    }
                    Button(
                        onClick = {
                            if (inputTenloai.isEmpty()) {
                                Toast.makeText(context, "Vui lòng nhập Category", Toast.LENGTH_SHORT).show()
                            } else {
                                onConfirm(inputTenloai)
                                onDismiss()
                            }
                        },
                        modifier = Modifier.width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt()),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Xác nhận", fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun DeleteLoaiSanphamDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    val context = LocalContext.current
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color("#221F1F".toColorInt()))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Thông báo !!! ", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Bạn có chắc chắn muốn xóa loại món ăn này?",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = onDismiss,
                        modifier = Modifier.width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt()),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Cancel", fontSize = 14.sp)
                    }
                    Button(
                        onClick = {
                            onConfirm()
                            onDismiss()
                        },
                        modifier = Modifier.width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt()),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Confirm", fontSize = 14.sp)
                    }
                }
            }
        }
    }
}