package com.example.duanxuong_comtam_kot104.data.category

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.duanxuong_comtam_kot104.entities.category.LoaiSanphamEntity

@Database(entities = [LoaiSanphamEntity::class], version = 2, exportSchema = false)
abstract class LoaiSanphamDB : RoomDatabase() {

    abstract fun LoaiSanphamDAO(): LoaiSanphamDAO

    companion object {

        @Volatile
        private var INTANCE: LoaiSanphamDB? = null

        fun getIntance(context: Context): LoaiSanphamDB {
            synchronized(this){
                var intance = INTANCE
                if (intance == null){
                    intance = Room.databaseBuilder(
                        context.applicationContext,
                        LoaiSanphamDB::class.java,
                        "loaiSp_db"
                    ).build()
                }
                return intance
            }

        }

    }

}


