package com.example.duanxuong_comtam_kot104.repository

import com.example.duanxuong_comtam_kot104.data.category.LoaiSanphamDB
import com.example.duanxuong_comtam_kot104.entities.category.LoaiSanphamEntity


class CategoryRepository(val LoaiSpDB: LoaiSanphamDB) {
    suspend fun addLoaiSanphamToRoom(LoaiSanphamEntity: LoaiSanphamEntity){
        LoaiSpDB.LoaiSanphamDAO().addLoaiSp(LoaiSanphamEntity)
    }

    fun getAllLoaiSanpham() = LoaiSpDB.LoaiSanphamDAO().getALlLoaiSp()

    suspend fun deleteLoaiSanphamFromRoom(LoaiSanphamEntity: LoaiSanphamEntity) {
        LoaiSpDB.LoaiSanphamDAO().deleteLoaiSp(LoaiSanphamEntity)
    }

    suspend fun updateLoaiSanpham(LoaiSanphamEntity: LoaiSanphamEntity){
        LoaiSpDB.LoaiSanphamDAO().updateLoaiSp(LoaiSanphamEntity)
    }
}
