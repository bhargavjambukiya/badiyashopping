package com.app.badiyashopping.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.badiyashopping.R
import com.app.badiyashopping.adapter.CategoryAdapter
import com.app.badiyashopping.adapter.ProductAdapter
import com.app.badiyashopping.adapter.ProductHomeAdapter
import com.app.badiyashopping.data.network.ApiInterface
import com.app.badiyashopping.databinding.FragmentCategoryBinding
import com.app.badiyashopping.databinding.FragmentProductsBinding
import com.app.badiyashopping.model.CategoryModel
import com.app.badiyashopping.model.ProductModel
import com.app.badiyashopping.repository.CategoryRepository
import com.app.badiyashopping.repository.ProductRepository
import com.app.badiyashopping.ui.activity.ProductDetailActivity
import com.app.badiyashopping.ui.base.BaseFragment
import com.app.badiyashopping.viewmodels.CategoryViewModel
import com.app.badiyashopping.viewmodels.ProductViewModel

class ProductFragment :
    BaseFragment<ProductViewModel, FragmentProductsBinding, ProductRepository>() {
    override fun getViewModel() = ProductViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentProductsBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        ProductRepository(remoteDataSource.buildApi(ApiInterface::class.java), userPreferences)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpProductAdapter()
    }

    private fun setUpProductAdapter() {
        val product = ProductModel(title = "Apple Royal Gala 1 KG", image = R.drawable.apple)
        val product1 = ProductModel(title = "Broccoli 250 g", image = R.drawable.brocoli)
        val product2 = ProductModel(title = "Brinjal 500 g", image = R.drawable.brinjal)
        val product3 = ProductModel(title = "banana 6 Pcs", image = R.drawable.banana)
        val product4 = ProductModel(title = "orange 1 KG", image = R.drawable.orange)

        val productsModelList = mutableListOf(product, product1, product2, product3, product4)
        val adapterProduct = ProductAdapter(productsModelList, context)
        binding.recyclerViewProducts.adapter = adapterProduct;
        adapterProduct.onItemClick = {
            val intent = Intent(context, ProductDetailActivity::class.java)
            startActivity(intent)
        }
    }
}