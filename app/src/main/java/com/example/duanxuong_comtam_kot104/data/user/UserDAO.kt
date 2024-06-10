package com.example.duanxuong_comtam_kot104.data.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.duanxuong_comtam_kot104.entities.dish.DishEntity
import com.example.duanxuong_comtam_kot104.entities.user.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Query("Select * From users")
    fun getAll() : Flow<List<UserEntity>>

    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("Select * From users Where userName = :userName and password = :pass")
    fun getUserByUsernamePass(userName: String, pass: String) : Flow<UserEntity>

    @Query("SELECT * FROM users WHERE userName = :userName LIMIT 1")
    fun getUserByUsername(userName: String): UserEntity?
    @Upsert
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)
}