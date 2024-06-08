package com.example.duanxuong_comtam_kot104.data.dish

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.duanxuong_comtam_kot104.entities.dish.DishEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DishDAO {
    @Insert
    suspend fun addDish(DishEntity: DishEntity)

    @Query("SELECT * FROM DishEntity")
    fun getALlDish(): Flow<List<DishEntity>>

    @Delete
    suspend fun deleteDish(DishEntity: DishEntity)

    @Update
    suspend fun updateDish(DishEntity: DishEntity)
}