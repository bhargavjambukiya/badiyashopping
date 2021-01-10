package com.app.badiyashopping.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.badiyashopping.R
import com.app.badiyashopping.adapter.MyOrdersAdapter
import com.app.badiyashopping.data.network.ApiInterface
import com.app.badiyashopping.databinding.FragmentMyOrdersBinding
import com.app.badiyashopping.model.ProductModel
import com.app.badiyashopping.repository.MyOrdersRepository
import com.app.badiyashopping.ui.base.BaseFragment
import com.app.badiyashopping.viewmodels.MyOrdersViewModel

class MyOrdersFragment :
    BaseFragment<MyOrdersViewModel, FragmentMyOrdersBinding, MyOrdersRepository>() {
    override fun getViewModel() = MyOrdersViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMyOrdersBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        MyOrdersRepository(remoteDataSource.buildApi(ApiInterface::class.java), userPreferences)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpProductAdapter()
    }

    private fun setUpProductAdapter() {
        val product = ProductModel(title = "1", image = 0)
        val product1 = ProductModel(title = "1", image = 0)
        val product2 = ProductModel(title = "1", image = 0)

        val productsModelList = mutableListOf(product, product1, product2)
        val adapterProduct = MyOrdersAdapter(productsModelList, context)
        binding.recyclerViewMyOrders.adapter = adapterProduct;
        adapterProduct.onItemClick = {

        }
    }
}