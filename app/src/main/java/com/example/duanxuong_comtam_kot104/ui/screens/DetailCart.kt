package com.example.duanxuong_comtam_kot104.ui.screens

import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comtam_kotlin_room.utils.Route
import com.example.duanxuong_comtam_kot104.R

data class ItemCart( val id:String,val name:String,val price:String,val quantity:String)
@Composable
fun DetailsCart(navHostController: NavHostController) {
   val mainItems = listOf(
      ItemCart("1", "Sườn Bì", "56k", "02"),
      ItemCart("2", "Bì chả", "25k", "01"),
      ItemCart("3", "Bì trứng", "25k", "03"),

   )
   val sideItems = listOf(
      ItemCart("1", "Chả Giò", "15k", "01"),
      ItemCart("2", "Gỏi Cuốn", "20k", "02"),
      ItemCart("3", "Gỏi Cuốn", "20k", "02"),
   )
   val ToppingItem = listOf(
      ItemCart("1", "Mỡ hành", "15k", "01"),
      ItemCart("2", "Tóp Mỡ", "20k", "02"),
   )
   val DifItem = listOf(
      ItemCart("1", "Khăn Giấy", "10k", "01"),
      ItemCart("2", "Khăn lạnh", "25k", "01"),
   )

   val combinedItems = listOf(
      "Món Chính" to mainItems,
      "Món Phụ" to sideItems,
      "Topping " to ToppingItem,
      "Khác" to DifItem
   )

   Box(
      modifier = Modifier
         .fillMaxSize()
         .background(Color.Black)
   ) {}

   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(top = 7.dp)
         .background(Color(0xff252121))
   ) {
      Column(
         modifier = Modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Row(
            modifier = Modifier
               .fillMaxWidth()
               .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
         ) {
            Button(
               onClick = { },
               modifier = Modifier
                  .padding(start = 25.dp)
                  .height(40.dp)
                  .width(150.dp),
               colors = ButtonDefaults.buttonColors(Color.DarkGray),
               shape = RoundedCornerShape(12.dp),
            ) {
               Text(text = "Xác Nhận", style = MaterialTheme.typography.titleMedium)
            }

            Button(
               onClick = {
                         navHostController.navigate(Route.Home.screen)
               },
               modifier = Modifier
                  .padding(end = 25.dp)
                  .height(40.dp)
                  .width(150.dp),
               colors = ButtonDefaults.buttonColors(Color.DarkGray),
               shape = RoundedCornerShape(12.dp),
            ) {
               Text(text = "Hủy", style = MaterialTheme.typography.titleMedium)
            }
         }

         LazyColumn(
            modifier = Modifier
               .padding(top = 7.dp)
               .background(Color(0xff252121))
         ) {
            combinedItems.forEach { (title, items) ->
               item {
                  Text(
                     text = title,
                     style = MaterialTheme.typography.titleLarge,
                     color = Color.White,
                     modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                  )
               }
               items(items) { item ->
                  ListItemViewMC(item = item, navHostController = navHostController)
               }
               item {
                  Divider(
                     thickness = 3.dp,
                     color = Color.White,
                     modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                  )
               }
            }
            item {
               Column(modifier = Modifier.padding(start = 10.dp)) {
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Số Nhà :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding( 10.dp)
                     )
                     Text(
                        text = "45",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Đường :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "15",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Phường :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "Đống Đa",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Quận :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "5",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Thành Phố :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "Hà Nội",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
               }
               Divider(
                  thickness = 3.dp,
                  color = Color.White,
                  modifier = Modifier.padding(start = 20.dp, end = 20.dp)
               )
               Column(modifier = Modifier.padding(start = 10.dp)) {
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Giờ :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding( 10.dp)
                     )
                     Text(
                        text = "13h45p",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Số điện thoại :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "0123456789",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Tổng số lượng món ăn :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "3",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Tổng số lượng món ăn thêm :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "3",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Tổng số lượng topping :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "2",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Tổng số lượng khác :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "2",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
                  Row(
                     modifier = Modifier
                        .padding(3.dp)
                        .fillMaxSize()
                  ) {

                     Text(
                        text = "Tổng tiền :",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                     Text(
                        text = "231k",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                     )
                  }
               }


            }
         }

      }
   }
}

@Composable
fun ListItemViewMC(item: ItemCart,navHostController: NavHostController) {
   Card(
      shape = RoundedCornerShape(20.dp),
      modifier = Modifier
         .padding(start = 20.dp, bottom = 10.dp, top = 10.dp)
         .width(366.dp)
         .height(76.dp)
         .fillMaxWidth(),
      elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
   ) {
      Box(
         modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray) // Màu nền của Card
      ) {
         Row(
            modifier = Modifier
               .fillMaxSize()
         ) {
            Image(
               painter = painterResource(R.drawable.img_monan),
               contentDescription = null,
               contentScale = ContentScale.Crop,
               modifier = Modifier
                  .width(90.dp)
                  .padding(top = 15.dp, start = 40.dp)
            )
         }
         Column {
            Text(
               text = item.name,
               style = MaterialTheme.typography.titleMedium,
               color = Color.White,
               modifier = Modifier.padding(start = 120.dp, top = 10.dp)
            )
            Text(
               text = item.price,
               style = MaterialTheme.typography.titleMedium,
               color = Color(0xFFFF8C00),
               modifier = Modifier.padding(start = 120.dp, top = 10.dp)
            )
         }
         Text(
            text = item.id,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.padding(top = 22.dp, start = 10.dp)
         )
         Text(
            text = item.quantity,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.padding(top = 22.dp, start = 300.dp)
         )
      }
   }
}
@Composable
fun DetailCartScreenPreview() {
   DetailsCart(navHostController = rememberNavController())
}



