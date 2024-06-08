package com.example.duanxuong_comtam_kot104.repository

import com.example.duanxuong_comtam_kot104.data.dish.DishDB
import com.example.duanxuong_comtam_kot104.entities.dish.DishEntity

class DishRepository(val DishDB: DishDB) {
    suspend fun addDishToRoom(DishEntity: DishEntity){
        DishDB.DishDAO().addDish(DishEntity)
    }

    fun getAllDish() = DishDB.DishDAO().getALlDish()

    suspend fun deleteDishFromRoom(DishEntity: DishEntity) {
        DishDB.DishDAO().deleteDish(DishEntity)
    }

    suspend fun updateDish(DishEntity: DishEntity){
        DishDB.DishDAO().updateDish(DishEntity)
    }
}
