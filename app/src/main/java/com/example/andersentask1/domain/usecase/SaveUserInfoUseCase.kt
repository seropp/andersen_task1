package com.example.andersentask1.domain.usecase

import com.example.andersentask1.domain.models.UserInfo
import com.example.andersentask1.domain.repository.UserRepository


class SaveUserInfoUseCase(private val userRepository: UserRepository) {

    fun execute(userInfo: UserInfo) {
        if (userInfo.age !is Int) userRepository.saveUserInfo(
            UserInfo(
                name = userInfo.name,
                lastName = userInfo.lastName,
                age = 0
            )
        ) else userRepository.saveUserInfo(userInfo)
    }
}