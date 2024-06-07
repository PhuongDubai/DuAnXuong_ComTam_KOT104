// ManagerScreen.kt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.comtam_kotlin_room.utils.Route
import com.example.duanxuong_comtam_kot104.R

@Composable
fun ManagerScreen(navController: NavController) {
    Scaffold(
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
                    Column {
                        Row(
                            modifier = Modifier
                                .padding(top=50.dp, start = 20.dp)
                                .clickable { navController.navigate(Route.AddCategory.screen) },
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
                            modifier = Modifier
                                .padding(top=30.dp, start = 20.dp)
                                .clickable { navController.navigate(Route.Dish.screen) },
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
                                fontWeight = FontWeight.W700,
                            )
                        }
                    }
                }
            }
        }
    )
}
