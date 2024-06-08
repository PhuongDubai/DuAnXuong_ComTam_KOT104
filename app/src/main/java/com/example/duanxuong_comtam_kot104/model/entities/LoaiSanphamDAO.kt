package com.example.duanxuong_comtam_kot104.model.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LoaiSanphamDAO {
    @Insert
    suspend fun addLoaiSp(LoaiSanphamEntity: LoaiSanphamEntity)

    @Query("SELECT * FROM LoaiSanphamEntity")
    fun getALlLoaiSp(): Flow<List<LoaiSanphamEntity>>

    @Delete
    suspend fun deleteLoaiSp(LoaiSanphamEntity: LoaiSanphamEntity)

    @Update
    suspend fun updateLoaiSp(LoaiSanphamEntity: LoaiSanphamEntity)
}

