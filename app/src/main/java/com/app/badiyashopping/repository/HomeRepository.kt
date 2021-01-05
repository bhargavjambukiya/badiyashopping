package com.app.badiyashopping.repository

import com.app.badiyashopping.UserPreferences
import com.app.badiyashopping.data.network.AuthApi

class HomeRepository(
    private val api: AuthApi,
    private val preferences: UserPreferences
) : BaseRepository(){


}