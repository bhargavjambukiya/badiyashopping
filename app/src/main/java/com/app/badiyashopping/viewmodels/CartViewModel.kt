package com.app.badiyashopping.viewmodels

import androidx.lifecycle.ViewModel
import com.app.badiyashopping.repository.CartRepository


class CartViewModel(
    private val repository: CartRepository
) : ViewModel() {


    fun makeApiCall() {
        // TODO: 24-12-2020 change data to dynamic

    }
}