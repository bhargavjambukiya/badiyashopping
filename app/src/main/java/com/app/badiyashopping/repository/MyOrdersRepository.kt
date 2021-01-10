package com.app.badiyashopping.repository

import com.app.badiyashopping.UserPreferences
import com.app.badiyashopping.data.network.ApiInterface

class MyOrdersRepository(
    private val apiInterface: ApiInterface,
    private val preferences: UserPreferences
) : BaseRepository(){


}