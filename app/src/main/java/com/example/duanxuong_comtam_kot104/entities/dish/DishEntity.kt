package com.example.duanxuong_comtam_kot104.entities.dish

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DishEntity(
    @PrimaryKey(autoGenerate = true) var dish_id: Int = 0,
    @ColumnInfo(name = "name") var tenMonAn: String?,
    @ColumnInfo(name = "category") var loaiMonAn: String?,
    @ColumnInfo(name = "price") var gia: Int?,
    @ColumnInfo(name = "imageUri") var imageUri: String? // Change here
    )