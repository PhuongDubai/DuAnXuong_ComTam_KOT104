package com.example.duanxuong_comtam_kot104.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.toColorInt
import com.example.duanxuong_comtam_kot104.R
import com.example.duanxuong_comtam_kot104.ui.components.MySpinner
import com.example.duanxuong_comtam_kot104.ui.components.MyToolbar

data class MonAn(
    val id: Int,
    val name: String,
    val price: Int,
    val imageResId: Int,
)

val MonAnList = listOf(
    MonAn(
        id = 1,
        name = "Sườn bì",
        price = 28,
        imageResId = R.drawable.img_monan,
    ),
    MonAn(
        id = 2,
        name = "Bì chả",
        price = 25,
        imageResId = R.drawable.img_monan,
    ),
    MonAn(
        id = 3,
        name = "Trứng chả",
        price = 25,
        imageResId = R.drawable.img_monan,
    ),
    MonAn(
        id = 4,
        name = "Sườn chả",
        price = 28,
        imageResId = R.drawable.img_monan,
    ),
    MonAn(
        id = 5,
        name = "Sườn bì chả",
        price = 35,
        imageResId = R.drawable.img_monan,
    ),
    MonAn(
        id = 6,
        name = "Sườn cây",
        price = 35,
        imageResId = R.drawable.img_monan,
    ),
    MonAn(
        id = 7,
        name = "Sườn trứng",
        price = 35,
        imageResId = R.drawable.img_monan,
    ),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListMonAnScreen(onBackClick: () -> Unit) {
    var showDeleteDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    var selectedMonAn by remember { mutableStateOf<MonAn?>(null) }

    Scaffold(
        topBar = {
            MyToolbar(
                title = "Danh sách món ăn",
                onBackClick = onBackClick,
                onAddClick = {
                    showAddDialog=true;
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
                    items = MonAnList,
                    onEditClick = { item ->
                        selectedMonAn = item
                        showEditDialog = true
                    },
                    onDeleteClick = { item ->
                        selectedMonAn = item
                        showDeleteDialog = true
                    }
                )
            }
            if (showDeleteDialog && selectedMonAn != null) {
                DeleteMonAnDialog(
                    monAn = selectedMonAn!!,
                    onConfirmDelete = {
                        // Xử lý sự kiện khi xóa món ăn
                        showDeleteDialog = false
                    },
                    onDismissRequest = {
                        showDeleteDialog = false
                    }
                )
            }
            if (showEditDialog && selectedMonAn != null) {
                EditMonAnDialog(
                    monAn = selectedMonAn!!,
                    onConfirmEdit = {
                        // Xử lý sự kiện khi xóa món ăn
                        showEditDialog = false
                    },
                    onDismiss = {
                        showEditDialog = false
                    }
                )
            }
            if (showAddDialog) {
                AddMonAnDialog(
                    onDismiss = { showAddDialog = false },
                    onConfirmAdd = {
                        // Xử lý khi xác nhận thêm món ăn
                        showAddDialog = false
                    }
                )
            }
        }
    )
}

@Composable
fun MonAnList(
    items: List<MonAn>,
    onDeleteClick: (MonAn) -> Unit,
    onEditClick: (MonAn) -> Unit
) {
    LazyColumn {
        items(items.size) { index ->
            MonAnItem(
                item = items[index],
                onDeleteClick = { onDeleteClick(items[index]) },
                onEditClick = { onEditClick(items[index]) }
            )
        }
    }
}

@Composable
fun MonAnItem(
    item: MonAn,
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
        Text("${item.id}", color = Color.White, fontSize = 20.sp)
        Spacer(modifier = Modifier.width(20.dp))
        Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = item.name,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Spacer(modifier = Modifier.width(25.dp))
        Column(modifier = Modifier.width(120.dp)) {
            Text(item.name, color = Color.White)
            Spacer(modifier = Modifier.height(15.dp))
            Text("${item.price}K", color = Color.Red)
        }
        Image(
            painter = painterResource(id = R.drawable.img_edit),
            contentDescription = "ImageEdit",
            modifier = Modifier
                .size(28.dp)
                .clickable { onEditClick() }
        )
        Spacer(modifier = Modifier.width(25.dp))
        Image(
            painter = painterResource(id = R.drawable.img_delete),
            contentDescription = "ImageDelete",
            modifier = Modifier
                .size(28.dp)
                .clickable { onDeleteClick() }
        )
    }
}

//dialog thêm
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMonAnDialog(onDismiss: () -> Unit,    onConfirmAdd: () -> Unit,) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(500.dp),
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
                val items_loaimon = listOf("Món chính", "Món phụ", "Đồ uống")
                var selectedItem_loaimon by remember { mutableStateOf(items_loaimon.first()) }
                var items_gia = listOf("5k-100k", "100k-500k", "Trên 500k")
                var selectedItem_gia by remember { mutableStateOf(items_gia.first()) }

                Image(
                    painter = painterResource(id = R.drawable.img_addmonan),
                    contentDescription = "AddImage",
                    modifier = Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Loại món", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                MySpinner(
                    items = items_loaimon,
                    selectedItem = selectedItem_loaimon,
                    onItemSelected = { selectedItem_loaimon = it }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Giá", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                MySpinner(
                    items = items_gia,
                    selectedItem = selectedItem_gia,
                    onItemSelected = { selectedItem_gia = it }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Tên món ăn",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                var tenMonAn by remember { mutableStateOf("") }
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(25.dp)
                        .background(Color.White, shape = RoundedCornerShape(5.dp)),
                    value = tenMonAn,
                    onValueChange = { tenMonAn = it },
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
                            containerColor = Color("#E0AB3C".toColorInt()),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Hủy", fontSize = 14.sp)
                    }
                    Button(
                        onClick = {onConfirmAdd()},
                        modifier = Modifier
                            .width(110.dp),
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

//dialog sửa
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditMonAnDialog(
    monAn: MonAn,
    onConfirmEdit: () -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .height(500.dp),
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
                var items_gia = listOf("5k-100k", "100k-500k", "Trên 500k")
                var selectedItem_gia by remember { mutableStateOf(items_gia.first()) }

                Image(
                    painter = painterResource(id = R.drawable.img_monan_edit),
                    contentDescription = "AddImage",
                    modifier = Modifier
                        .size(150.dp)
//                        .shadow(
//                            elevation = 25.dp,
//                            shape = RoundedCornerShape(20.dp),
//                            ambientColor = Color.White.copy(alpha = 0.1f),
//                            spotColor = Color.White.copy(alpha = 0.1f)
//                        )
                        .clip(RoundedCornerShape(20.dp))
                )
                Spacer(modifier = Modifier.height(30.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Tên món ăn",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                var tenMonAn by remember { mutableStateOf("") }
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(25.dp)
                        .background(Color.White, shape = RoundedCornerShape(5.dp)),
                    value = tenMonAn,
                    onValueChange = { tenMonAn = it },
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Giá", color = Color.White, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(10.dp))
                MySpinner(
                    items = items_gia,
                    selectedItem = selectedItem_gia,
                    onItemSelected = { selectedItem_gia = it }
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
                            containerColor = Color("#E0AB3C".toColorInt()),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Hủy", fontSize = 14.sp)
                    }
                    Button(
                        onClick = {onConfirmEdit()},
                        modifier = Modifier
                            .width(110.dp),
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

//dialog xóa
@Composable
fun DeleteMonAnDialog(
    monAn: MonAn,
    onConfirmDelete: () -> Unit,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color("#EBE9E9".toColorInt()))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Thông Báo",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Bạn có chắc chắn muốn xóa món ăn ${monAn.name} này không ?",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = onDismissRequest,
                        modifier = Modifier
                            .width(110.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#E0AB3C".toColorInt()),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Hủy", fontSize = 14.sp)
                    }
                    Button(
                        onClick = onConfirmDelete,
                        modifier = Modifier
                            .width(110.dp),
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

@Preview(showBackground = true)
@Composable
fun ListMonAnScreenPreview() {
    ListMonAnScreen(onBackClick = {})
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DeleteMonAnDialog(
        monAn = MonAn(1, "Cơm tấm", 30, R.drawable.img_monan),
        onConfirmDelete = { /* TODO */ }) {
        // Dismiss action
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDiaLogAdd() {
    AddMonAnDialog(onDismiss = {}, onConfirmAdd = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewDiaLogEdit() {
    EditMonAnDialog(        monAn = MonAn(1, "Cơm tấm", 30, R.drawable.img_monan),onDismiss = {}, onConfirmEdit = {})
}
