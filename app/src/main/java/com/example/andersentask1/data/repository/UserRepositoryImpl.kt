package com.example.andersentask1.data.repository

import com.example.andersentask1.data.storage.UserStorage
import com.example.andersentask1.data.storage.models.UserInfoData
import com.example.andersentask1.domain.models.UserInfo
import com.example.andersentask1.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveUserInfo(userInfo: UserInfo) {
        userStorage.save(mapToStorage(userInfo = userInfo))
    }

    override fun getUserInfo(): UserInfo {
        val user = mapToUserInfo(userStorage.get())
        return UserInfo(
            name = user.name,
            lastName = user.lastName,
            age = user.age
        )
    }

    private fun mapToStorage(userInfo: UserInfo): UserInfoData {
        return UserInfoData(
            name = userInfo.name,
            lastName = userInfo.lastName,
            age = userInfo.age
        )
    }

    private fun mapToUserInfo(userInfoData: UserInfoData): UserInfo {
        return UserInfo(
            name = userInfoData.name,
            lastName = userInfoData.lastName,
            age = userInfoData.age
        )
    }
}