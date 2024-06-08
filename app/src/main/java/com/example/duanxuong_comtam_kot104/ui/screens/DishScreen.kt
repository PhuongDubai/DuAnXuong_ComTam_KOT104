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
    var selectedMonAn by remember { mutableStateOf<MonAn?>(null) }

    Scaffold(
        topBar = {
            MyToolbar(
                title = "Danh sách món ăn",
                onBackClick = onBackClick
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
                    MonAnList(
                        items = MonAnList,
                        onEditClick = { item ->
                            // Handle edit click event here
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
        verticalAlignment = Alignment.CenterVertically,

        
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
    DeleteMonAnDialog(monAn = MonAn(1, "Cơm tấm", 30, R.drawable.img_monan), onConfirmDelete = { /* TODO */ }) {
        // Dismiss action
    }
}
