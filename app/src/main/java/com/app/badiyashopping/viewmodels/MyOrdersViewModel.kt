package com.app.badiyashopping.viewmodels

import androidx.lifecycle.ViewModel
import com.app.badiyashopping.repository.MyOrdersRepository


class MyOrdersViewModel(
    private val repository: MyOrdersRepository
) : ViewModel() {


    fun makeApiCall() {
        // TODO: 24-12-2020 change data to dynamic

    }
}