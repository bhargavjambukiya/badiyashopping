package com.app.badiyashopping.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.badiyashopping.R
import com.app.badiyashopping.adapter.MyOrdersAdapter
import com.app.badiyashopping.data.network.ApiInterface
import com.app.badiyashopping.databinding.FragmentMyOrdersBinding
import com.app.badiyashopping.databinding.FragmentSettingsBinding
import com.app.badiyashopping.model.ProductModel
import com.app.badiyashopping.repository.MyOrdersRepository
import com.app.badiyashopping.repository.SettingsRepository
import com.app.badiyashopping.ui.base.BaseFragment
import com.app.badiyashopping.viewmodels.MyOrdersViewModel
import com.app.badiyashopping.viewmodels.SettingsViewModel

class SettingsFragment :
    BaseFragment<SettingsViewModel, FragmentSettingsBinding, SettingsRepository>() {
    override fun getViewModel() = SettingsViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        SettingsRepository(remoteDataSource.buildApi(ApiInterface::class.java), userPreferences)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}