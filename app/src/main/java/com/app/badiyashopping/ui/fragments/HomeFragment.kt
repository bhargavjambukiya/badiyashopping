package com.app.badiyashopping.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.badiyashopping.R
import com.app.badiyashopping.adapter.CategoryAdapter
import com.app.badiyashopping.adapter.HomeCarouselAdapter
import com.app.badiyashopping.adapter.ProductAdapter
import com.app.badiyashopping.data.network.AuthApi
import com.app.badiyashopping.databinding.FragmentHomeBinding
import com.app.badiyashopping.model.CategoryModel
import com.app.badiyashopping.model.ProductModel
import com.app.badiyashopping.repository.HomeRepository
import com.app.badiyashopping.ui.activity.ProductDetailActivity
import com.app.badiyashopping.ui.base.BaseFragment
import com.app.badiyashopping.viewmodels.HomeViewModel


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, HomeRepository>() {
    override fun getViewModel() = HomeViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        HomeRepository(remoteDataSource.buildApi(AuthApi::class.java), userPreferences)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()

    }

    fun setUp() {
        val carouselList =
            mutableListOf(
                R.drawable.carousel1,
                R.drawable.carousel2,
                R.drawable.carousel4,
                R.drawable.carousel3
            )
        val carouselAdapter = HomeCarouselAdapter(carouselList, context)
        binding.viewPagerCarousel.adapter = carouselAdapter
        // TODO: 24-12-2020 Replace with dynamic data from api
        val category = CategoryModel(title = "See All", image = R.drawable.ic_all)
        val category1 = CategoryModel(title = "Fruits", image = R.drawable.ic_fruits)
        val category2 = CategoryModel(title = "Vegetables", image = R.drawable.ic_vegetables)
        val category3 = CategoryModel(title = "Baby Care", image = R.drawable.ic_baby_care)
        val category4 = CategoryModel(title = "Beverages", image = R.drawable.ic_bevrages)
        val categoryModelList = mutableListOf(category, category1, category2, category3, category4)
        val adapter = CategoryAdapter(categoryModelList, context)
        binding.recyclerViewCategory.adapter = adapter

        adapter.onItemClick = {

        }

        val product = ProductModel(title = "Apple", image = R.drawable.apple)
        val product1 = ProductModel(title = "Broccoli", image = R.drawable.brocoli)
        val product2 = ProductModel(title = "Brinjal", image = R.drawable.brinjal)
        val product3 = ProductModel(title = "banana", image = R.drawable.banana)
        val product4 = ProductModel(title = "orange", image = R.drawable.orange)

        val productsModelList = mutableListOf(product, product1, product2, product3, product4)
        val adapterProduct = ProductAdapter(productsModelList, context)
        binding.recyclerViewPopular.adapter = adapterProduct;
        adapterProduct.onItemClick = {
            val intent = Intent(context, ProductDetailActivity::class.java)
            startActivity(intent)
        }


        val newestProduct = ProductAdapter(productsModelList, context)
        binding.recyclerViewNewestProduct.adapter = newestProduct;
        newestProduct.onItemClick = {
            val intent = Intent(context, ProductDetailActivity::class.java)
            startActivity(intent)
        }
    }
}