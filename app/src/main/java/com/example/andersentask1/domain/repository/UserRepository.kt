package com.example.andersentask1.domain.repository

import com.example.andersentask1.domain.models.UserInfo

interface UserRepository {

    fun saveUserInfo(userInfo: UserInfo)

    fun getUserInfo(): UserInfo
}