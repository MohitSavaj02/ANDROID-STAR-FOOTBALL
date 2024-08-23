package com.example.baseproject.utils

import android.content.SharedPreferences

class PrefUtils(private val sharedPreferences: SharedPreferences) {

    fun saveAuthToken(token: String?) {
        sharedPreferences.edit().putString(AppConstant.CONSTANT_AUTH, token).apply()
    }

    fun getAuthToken(): String? {
        return sharedPreferences.getString(AppConstant.CONSTANT_AUTH, null)
    }


    fun isUserLoggedIn(): Boolean {
        return !getAuthToken().isNullOrEmpty()
    }

    fun clearPref() {
        sharedPreferences.edit().clear().apply()
    }

}