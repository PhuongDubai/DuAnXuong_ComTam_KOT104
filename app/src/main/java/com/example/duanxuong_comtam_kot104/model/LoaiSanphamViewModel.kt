package com.example.duanxuong_comtam_kot104.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duanxuong_comtam_kot104.model.entities.LoaiSanphamEntity
import com.example.duanxuong_comtam_kot104.repository.Repository
import kotlinx.coroutines.launch

class LoaiSanphamViewModel(val repository: Repository): ViewModel() {
    fun addLoaiSanpham(sanpham: LoaiSanphamEntity) {
        viewModelScope.launch {
            repository.addLoaiSanphamToRoom(sanpham)
        }
    }

    val loaisanphams = repository.getAllLoaiSanpham()

    fun deleteLoaiSanpham(sanpham: LoaiSanphamEntity) {
        viewModelScope.launch {
            repository.deleteLoaiSanphamFromRoom(sanpham)
        }
    }

    fun updateLoaiSanpham(sanpham: LoaiSanphamEntity) {
        viewModelScope.launch {
            repository.updateLoaiSanpham(sanpham)
        }
    }
}