package com.example.duanxuong_comtam_kot104.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duanxuong_comtam_kot104.entities.dish.DishEntity
import com.example.duanxuong_comtam_kot104.repository.DishRepository
import kotlinx.coroutines.launch

class DishViewModel(val dishRepository: DishRepository): ViewModel() {
    fun addDish(dish: DishEntity) {
        viewModelScope.launch {
            dishRepository.addDishToRoom(dish)
        }
    }

    val dishes = dishRepository.getAllDish()

    fun deleteDish(dish: DishEntity) {
        viewModelScope.launch {
            dishRepository.deleteDishFromRoom(dish)
        }
    }

    fun updateDish(dish: DishEntity) {
        viewModelScope.launch {
            dishRepository.updateDish(dish)
        }
    }
}