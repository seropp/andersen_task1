package com.example.andersentask1.presentation.mvvm_userInfo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.andersentask1.data.repository.UserRepositoryImpl
import com.example.andersentask1.data.storage.sharedpref.SharedPrefUserStorage
import com.example.andersentask1.domain.usecase.GetUserInfoUseCase
import com.example.andersentask1.domain.usecase.SaveUserInfoUseCase

class UserInfoVIewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepositoryImpl by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(context = context)
        )
    }

    private val saveUserInfoUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserInfoUseCase(
            userRepositoryImpl
        )
    }

    private val getUserInfoUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserInfoUseCase(
            userRepositoryImpl
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserInfoVIewModel(
            saveUserInfoUseCase = saveUserInfoUseCase,
            getUserInfoUseCase = getUserInfoUseCase
        ) as T
    }
}