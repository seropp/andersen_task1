package com.example.andersentask1.data.storage.sharedpref

import android.content.Context
import com.example.andersentask1.data.storage.UserStorage
import com.example.andersentask1.data.storage.models.UserInfoData

const val SHARED_PREFS_NAME = "shared_preference"

const val KEY_NAME = "shared name"
const val KEY_LAST_NAME = "shared last name"
const val KEY_AGE = "shared age"

const val DEFAULT_NAME = "NAME"
const val DEFAULT_LAST_NAME = "LAST NAME"
const val DEFAULT_AGE = 33

class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(userInfoData: UserInfoData) {
        sharedPreferences.edit().putString(KEY_NAME, userInfoData.name).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, userInfoData.lastName).apply()
        sharedPreferences.edit().putInt(KEY_AGE, userInfoData.age).apply()
    }

    override fun get(): UserInfoData {
        return UserInfoData(
            name = sharedPreferences.getString(KEY_NAME, DEFAULT_NAME) ?: DEFAULT_NAME,
            lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME)
                ?: DEFAULT_LAST_NAME,
            age = sharedPreferences.getInt(KEY_AGE, DEFAULT_AGE) ?: DEFAULT_AGE
        )
    }
}