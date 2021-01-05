package com.app.badiyashopping.repository

import com.app.badiyashopping.UserPreferences
import com.app.badiyashopping.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi,
    private val preferences: UserPreferences
) : BaseRepository(){
/*
    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }

    suspend fun saveAuthToken(token: String){
        preferences.saveAuthToken(token)
    }*/

}