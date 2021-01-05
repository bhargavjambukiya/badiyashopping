package com.app.badiyashopping.viewmodels

import androidx.lifecycle.ViewModel
import com.app.badiyashopping.repository.HomeRepository


class HomeViewModel(
    private val repository: HomeRepository
) : ViewModel() {

    
    fun makeApiCall() {
        // TODO: 24-12-2020 change data to dynamic

    }
}