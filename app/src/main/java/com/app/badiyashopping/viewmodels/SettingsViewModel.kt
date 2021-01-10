package com.app.badiyashopping.viewmodels

import androidx.lifecycle.ViewModel
import com.app.badiyashopping.repository.MyOrdersRepository
import com.app.badiyashopping.repository.SettingsRepository


class SettingsViewModel(
    private val repository: SettingsRepository
) : ViewModel() {


    fun makeApiCall() {
        // TODO: 24-12-2020 change data to dynamic

    }
}