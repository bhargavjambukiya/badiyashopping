package com.app.badiyashopping.repository

import com.app.badiyashopping.UserPreferences
import com.app.badiyashopping.data.network.ApiInterface

class HomeRepository(
    private val apiInterface: ApiInterface,
    private val preferences: UserPreferences
) : BaseRepository(){


}