package com.example.andersentask1.data.storage

import com.example.andersentask1.data.storage.models.UserInfoData

interface UserStorage {

    fun save(userInfoData: UserInfoData)

    fun get(): UserInfoData
}