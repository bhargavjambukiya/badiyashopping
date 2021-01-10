package com.app.badiyashopping.viewmodels

import androidx.lifecycle.ViewModel
import com.app.badiyashopping.repository.ProductRepository


class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {


    fun makeApiCall() {
        // TODO: 24-12-2020 change data to dynamic

    }
}