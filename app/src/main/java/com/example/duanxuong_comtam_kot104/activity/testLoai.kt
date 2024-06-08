package com.example.duanxuong_comtam_kot104.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.duanxuong_comtam_kot104.R
import com.example.duanxuong_comtam_kot104.model.LoaiSanphamViewModel
import com.example.duanxuong_comtam_kot104.model.entities.LoaiSanphamDB
import com.example.duanxuong_comtam_kot104.repository.Repository
import com.example.duanxuong_comtam_kot104.ui.screens.CategoryScreen

class testLoai : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}