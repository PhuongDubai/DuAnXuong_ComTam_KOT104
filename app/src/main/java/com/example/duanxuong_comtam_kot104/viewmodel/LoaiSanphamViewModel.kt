package com.example.duanxuong_comtam_kot104.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duanxuong_comtam_kot104.entities.category.LoaiSanphamEntity
import com.example.duanxuong_comtam_kot104.repository.CategoryRepository
import kotlinx.coroutines.launch

class LoaiSanphamViewModel(val categoryRepository: CategoryRepository): ViewModel() {
    fun addLoaiSanpham(sanpham: LoaiSanphamEntity) {
        viewModelScope.launch {
            categoryRepository.addLoaiSanphamToRoom(sanpham)
        }
    }

    val loaisanphams = categoryRepository.getAllLoaiSanpham()

    fun deleteLoaiSanpham(sanpham: LoaiSanphamEntity) {
        viewModelScope.launch {
            categoryRepository.deleteLoaiSanphamFromRoom(sanpham)
        }
    }

    fun updateLoaiSanpham(sanpham: LoaiSanphamEntity) {
        viewModelScope.launch {
            categoryRepository.updateLoaiSanpham(sanpham)
        }
    }
}

