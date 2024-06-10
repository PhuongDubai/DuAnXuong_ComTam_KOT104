package com.example.duanxuong_comtam_kot104.repository

import com.example.duanxuong_comtam_kot104.data.user.UserDB
import com.example.duanxuong_comtam_kot104.entities.user.UserEntity

class UserRepository(val UserDB: UserDB) {
    suspend fun addUserToRoom(UserEntity: UserEntity){
        UserDB.UserDAO().insertUser(UserEntity)
    }

    fun getAllUser() = UserDB.UserDAO().getAll()

    suspend fun deleteUserFromRoom(UserEntity: UserEntity) {
        UserDB.UserDAO().deleteUser(UserEntity)
    }

    suspend fun updateUser(UserEntity: UserEntity){
        UserDB.UserDAO().updateUser(UserEntity)
    }
}
