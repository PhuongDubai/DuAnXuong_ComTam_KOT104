package com.example.duanxuong_comtam_kot104.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoaiSanphamEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "tenLoaiSp") var tenLoaiSp: String?,

)