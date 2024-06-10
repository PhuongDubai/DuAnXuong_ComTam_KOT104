package com.example.duanxuong_comtam_kot104.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.duanxuong_comtam_kot104.data.user.UserDAO
import com.example.duanxuong_comtam_kot104.entities.user.UserEntity
import kotlinx.coroutines.launch

class LoginViewModel(private val dao: UserDAO) : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _isAuthenticated = MutableLiveData<Boolean?>()
    val isAuthenticated: LiveData<Boolean?> = _isAuthenticated

    private val _isShowPassword = MutableLiveData<Boolean>()
    val isShowPassword: LiveData<Boolean> = _isShowPassword


    private val _isRole = MutableLiveData<Int>()
    val isRole: LiveData<Int> = _isRole

    fun insertSampleAdminIfNeeded() {

        viewModelScope.launch {
            var users: List<UserEntity> = listOf()
            dao.getAll().collect {
                users = it
                if (users.isEmpty()) {
                    dao.insertUser(
                        UserEntity(
                            userName = "admin",
                            password = "123",
                            "admin@gmail.com",
                            0
                        )
                    )
                    dao.insertUser(
                        UserEntity(
                            userName = "huy",
                            password = "123",
                            "huy@gmail.com",
                            0
                        )
                    )
                    dao.insertUser(
                        UserEntity(
                            userName = "vinh",
                            password = "123",
                            "vinh@gmail.com",
                            0
                        )
                    )
                    dao.insertUser(
                        UserEntity(
                            userName = "phuong",
                            password = "123",
                            "phuong@gmail.com",
                            0
                        )
                    )
                }
            }
        }
    }


    fun login(username: String, password: String) {

        viewModelScope.launch {

            val user = dao.getUserByUsernamePass(username, password)
            user.collect {
                if (it != null) {
                    _isAuthenticated.value = true
                    _isRole.value = it.role

                } else {
                    _isAuthenticated.value = false
                }
            }
        }
    }

    fun resetAuthenticationState() {
        _isAuthenticated.value = null
    }

}