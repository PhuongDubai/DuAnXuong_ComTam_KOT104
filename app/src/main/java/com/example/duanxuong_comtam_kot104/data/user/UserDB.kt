package com.example.duanxuong_comtam_kot104.data.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.duanxuong_comtam_kot104.entities.user.UserEntity

@Database(entities = [UserEntity::class], version = 4, exportSchema = false)
abstract class UserDB : RoomDatabase() {

    abstract fun UserDAO(): UserDAO

    companion object {

        @Volatile
        private var INTANCE: UserDB? = null

        fun getIntance(context: Context): UserDB {
            synchronized(this){
                var intance = INTANCE
                if (intance == null){
                    intance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDB::class.java,
                        "user_db1"
                    ).build()
                }
                return intance
            }

        }

    }

}