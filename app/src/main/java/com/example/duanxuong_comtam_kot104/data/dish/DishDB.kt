package com.example.duanxuong_comtam_kot104.data.dish

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.duanxuong_comtam_kot104.entities.dish.DishEntity

@Database(entities = [DishEntity::class], version = 3, exportSchema = false)
abstract class DishDB : RoomDatabase() {

    abstract fun DishDAO(): DishDAO

    companion object {

        @Volatile
        private var INTANCE: DishDB? = null

        fun getIntance(context: Context): DishDB {
            synchronized(this){
                var intance = INTANCE
                if (intance == null){
                    intance = Room.databaseBuilder(
                        context.applicationContext,
                        DishDB::class.java,
                        "dish_db1"
                    ).build()
                }
                return intance
            }

        }

    }

}