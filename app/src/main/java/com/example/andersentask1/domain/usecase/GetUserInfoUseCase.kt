package com.example.andersentask1.domain.usecase

import com.example.andersentask1.domain.models.UserInfo
import com.example.andersentask1.domain.repository.UserRepository

class GetUserInfoUseCase(private val userRepository: UserRepository) {

    fun execute(): UserInfo {
        return UserInfo(
            name = userRepository.getUserInfo().name,
            lastName = userRepository.getUserInfo().lastName,
            age = userRepository.getUserInfo().age
        )
    }
}