package com.example.andersentask1.presentation.mvvm_userInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andersentask1.domain.models.UserInfo
import com.example.andersentask1.domain.usecase.GetUserInfoUseCase
import com.example.andersentask1.domain.usecase.SaveUserInfoUseCase

class UserInfoVIewModel(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val saveUserInfoUseCase: SaveUserInfoUseCase
) : ViewModel() {

    var nameLiveData = MutableLiveData<String>()
    var lastNameLiveData = MutableLiveData<String>()
    var ageLiveData = MutableLiveData<Int>()

    fun save(name: String, lastName: String, age: Int) {
        saveUserInfoUseCase.execute(
            UserInfo(
                name = name,
                lastName = lastName,
                age = age
            )
        )
    }

    fun load() {
        val userInfo = getUserInfoUseCase.execute()
        nameLiveData.value = userInfo.name
        lastNameLiveData.value = userInfo.lastName
        ageLiveData.value = userInfo.age
    }
}