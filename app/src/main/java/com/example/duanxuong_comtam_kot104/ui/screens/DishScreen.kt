package com.example.duanxuong_comtam_kot104.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.duanxuong_comtam_kot104.R
import com.example.duanxuong_comtam_kot104.entities.category.LoaiSanphamEntity
import com.example.duanxuong_comtam_kot104.entities.dish.DishEntity
import com.example.duanxuong_comtam_kot104.ui.components.MySpinner
import com.example.duanxuong_comtam_kot104.ui.components.MyToolbar
import com.example.duanxuong_comtam_kot104.viewmodel.DishViewModel
import com.example.duanxuong_comtam_kot104.viewmodel.LoaiSanphamViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishScreen(
    navController: NavController,
    dishViewModel: DishViewModel,
    loaiSanphamViewModel: LoaiSanphamViewModel
) {
    var tenMonAn by remember { mutableStateOf("") }
    var loaiMonAn by remember { mutableStateOf("") }
    var gia by remember { mutableStateOf("0") }
    var inputImageResId by remember { mutableStateOf<Int?>(null) }

    val emty by remember { mutableStateOf("") }
    val dishes by dishViewModel.dishes.collectAsState(initial = emptyList())
    val loaiSanphams by loaiSanphamViewModel.loaisanphams.collectAsState(initial = emptyList())
    var showDeleteDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    var selectedDish by remember { mutableStateOf<DishEntity?>(null) }

    Scaffold(
        topBar = {
            MyToolbar(
                title = "Danh sách món ăn",
                navController = navController,
                onAddClick = {
                    showAddDialog = true
                }
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(color = Color("#221F1F".toColorInt()))
                    .padding(10.dp)
            ) {
                MonAnList(
                    dishes = dishes,
                    onEditClick = { item ->
                        selectedDish = item
                        showEditDialog = true
                    },
                    onDeleteClick = { item ->
                        selectedDish = item
                        showDeleteDialog = true
                    }
                )
            }
            if (showDeleteDialog && selectedDish != null) {
                DeleteMonAnDialog(
                    monAn = selectedDish!!,
                    onConfirmDelete = {
                        dishViewModel.deleteDish(selectedDish!!)
                        showDeleteDialog = false
                    },
                    onDismissRequest = {
                        showDeleteDialog = false
                    }
                )
            }
            if (showEditDialog && selectedDish != null) {
                EditMonAnDialog(
                    monAn = selectedDish!!,
                    categories = loaiSanphams,
                    onConfirmEdit = { updatedDish ->
                        dishViewModel.updateDish(updatedDish)
                        showEditDialog = false
                    },
                    onDismiss = {
                        showEditDialog = false
                    }
                )
            }
            if (showAddDialog) {
                AddMonAnDialog(
                    categories = loaiSanphams,
                    onDismiss = { showAddDialog = false },
                    onConfirmAdd = { newDish ->
                        dishViewModel.addDish(newDish)
                        showAddDialog = false
                    }
                )
            }
        }
    )
}


@Composable
fun MonAnList(
    dishes: List<DishEntity>,
    onDeleteClick: (DishEntity) -> Unit,
    onEditClick: (DishEntity) -> Unit
) {
    LazyColumn {
        items(dishes) { dish ->
            MonAnItem(
                dish = dish,  // Corrected to singular form 'dish'
                onDeleteClick = { onDeleteClick(dish) },
                onEditClick = { onEditClick(dish) }
            )
        }
    }
}


@Composable
fun MonAnItem(
    dish: DishEntity,
    onDeleteClick: () -> Unit,
    onEditClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(10.dp)
            .height(82.dp)
            .background(Color("#2B2929".toColorInt()), shape = RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Text("${dish.dish_id}", color = Color.White, fontSize = 20.sp)
        Spacer(modifier = Modifier.width(20.dp))
        dish.imageUri?.let {
            Image(
                painter = rememberAsyncImagePainter(model = it),
                contentDescription = dish.tenMonAn,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
        }
        Spacer(modifier = Modifier.width(25.dp))
        Column(modifier = Modifier.width(120.dp)) {
            dish.tenMonAn?.let { Text(it, color = Color.White) }
            Spacer(modifier = Modifier.height(15.dp))
            Text("${dish.gia}K", color = Color.Red)
        }
        Image(
            painter = painterResource(id = R.drawable.img_edit),
            contentDescription = "Edit Image",
            modifier = Modifier
                .size(28.dp)
                .clickable { onEditClick() }
        )
        Spacer(modifier = Modifier.width(25.dp))
        Image(
            painter = painterResource(id = R.drawable.img_delete),
            contentDescription = "Delete Image",
            modifier = Modifier
                .size(28.dp)
                .clickable { onDeleteClick() }
        )
    }
}



//dialog thêm
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMonAnDialog(
    categories: List<LoaiSanphamEntity>,
    onDismiss: () -> Unit,
    onConfirmAdd: (DishEntity) -> Unit
) {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var tenMonAn by remember { mutableStateOf("") }
    var loaiMonAn by remember { mutableStateOf(categories.firstOrNull()?.tenLoaiSp ?: "") }
    var gia by remember { mutableStateOf("0") }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(700.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .height(800.dp)
                    .background(color = Color("#221F1F".toColorInt()))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = if (selectedImageUri != null) {
                        rememberAsyncImagePainter(model = selectedImageUri)
                    } else {
                        painterResource(id = R.drawable.img_addmonan)
                    },
                    contentDescription = "Add Image",
                    modifier = Modifier
                        .size(150.dp)
                        .clickable {
                            launcher.launch("image/*")
                        }
                )
                Spacer(modifier = Modifier.height(30.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Loại món", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                MySpinner(
                    items = categories.map { it.tenLoaiSp },
                    selectedItem = loaiMonAn,
                    onItemSelected = { loaiMonAn = it }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Giá", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(5.dp)),
                    value = gia,
                    onValueChange = { gia = it },
                    textStyle = TextStyle(color = Color.Black)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Tên món ăn",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = tenMonAn,
                    onValueChange = { tenMonAn = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(5.dp))
                )
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { onDismiss() },
                        modifier = Modifier
                            .width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt())
                        )
                    ) {
                        Text(text = "Hủy")
                    }

                    Button(
                        onClick = {
                            onConfirmAdd(
                                DishEntity(
                                    dish_id = 0,
                                    tenMonAn = tenMonAn,
                                    loaiMonAn = loaiMonAn,
                                    gia = gia.toIntOrNull() ?: 0,
                                    imageUri = selectedImageUri?.toString() // Convert URI to string
                                )
                            )
                        },
                        modifier = Modifier
                            .width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt())
                        )
                    ) {
                        Text(text = "Thêm")
                    }
                }
            }
        }
    }
}




//dialog sửa
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditMonAnDialog(
    monAn: DishEntity,
    categories: List<LoaiSanphamEntity>,
    onDismiss: () -> Unit,
    onConfirmEdit: (DishEntity) -> Unit
) {
    var tenMonAn by remember { mutableStateOf(monAn.tenMonAn ?: "") }
    var selectedCategory by remember { mutableStateOf(monAn.loaiMonAn ?: categories.firstOrNull()?.tenLoaiSp ?: "") }
    var gia by remember { mutableStateOf(monAn.gia.toString()) }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var initialImageUri = monAn.imageUri

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(500.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color("#221F1F".toColorInt()))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = if (selectedImageUri != null) {
                        rememberAsyncImagePainter(model = selectedImageUri)
                    } else {
                        rememberAsyncImagePainter(model = initialImageUri) // Load existing image
                    },
                    contentDescription = "Edit Image",
                    modifier = Modifier
                        .size(150.dp)
                        .clickable {
                            launcher.launch("image/*")
                        }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Tên món ăn", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = tenMonAn,
                    onValueChange = { tenMonAn = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(5.dp))
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Loại món", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                MySpinner(
                    items = categories.map { it.tenLoaiSp },
                    selectedItem = selectedCategory,
                    onItemSelected = { selectedCategory = it }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Giá", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(Color.White, shape = RoundedCornerShape(5.dp)),
                    value = gia,
                    onValueChange = { gia = it },
                    textStyle = TextStyle(color = Color.Black)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { onDismiss() },
                        modifier = Modifier
                            .width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt())
                        )
                    ) {
                        Text(text = "Hủy")
                    }

                    Button(
                        onClick = {
                            onConfirmEdit(
                                DishEntity(
                                    dish_id = monAn.dish_id,
                                    tenMonAn = tenMonAn,
                                    loaiMonAn = selectedCategory,
                                    gia = gia.toIntOrNull() ?: 0,
                                    imageUri = selectedImageUri?.toString() ?: initialImageUri // Use new or old image URI
                                )
                            )
                        },
                        modifier = Modifier
                            .width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt())
                        )
                    ) {
                        Text(text = "Lưu")
                    }
                }
            }
        }
    }
}




//dialog xóa
@Composable
fun DeleteMonAnDialog(
    monAn: DishEntity,
    onConfirmDelete: () -> Unit,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = "Xác nhận xóa món ăn") },
        text = { Text(text = "Bạn có chắc chắn muốn xóa món ăn này?") },
        confirmButton = {
            TextButton(
                onClick = onConfirmDelete
            ) {
                Text("Xóa")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismissRequest
            ) {
                Text("Hủy")
            }
        }
    )
}

