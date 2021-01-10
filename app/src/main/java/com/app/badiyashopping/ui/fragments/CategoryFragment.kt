package com.app.badiyashopping.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.badiyashopping.R
import com.app.badiyashopping.adapter.CategoryAdapter
import com.app.badiyashopping.data.network.ApiInterface
import com.app.badiyashopping.databinding.FragmentCategoryBinding
import com.app.badiyashopping.model.CategoryModel
import com.app.badiyashopping.repository.CategoryRepository
import com.app.badiyashopping.ui.base.BaseFragment
import com.app.badiyashopping.viewmodels.CategoryViewModel

class CategoryFragment :
    BaseFragment<CategoryViewModel, FragmentCategoryBinding, CategoryRepository>() {
    override fun getViewModel() = CategoryViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCategoryBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        CategoryRepository(remoteDataSource.buildApi(ApiInterface::class.java), userPreferences)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpCategoryAdapter()
    }

    private fun setUpCategoryAdapter() {
        val category1 = CategoryModel(title = "Fruits", image = R.drawable.ic_fruits)
        val category2 = CategoryModel(title = "Vegetables", image = R.drawable.ic_vegetables)
        val category3 = CategoryModel(title = "Baby Care", image = R.drawable.ic_baby_care)
        val category4 = CategoryModel(title = "Beverages", image = R.drawable.ic_bevrages)
        val categoryModelList = mutableListOf(category1, category2, category3, category4)
        val adapter = CategoryAdapter(categoryModelList, context)
        binding.recyclerViewCategory.adapter = adapter
        adapter.onItemClick = {

        }
    }
}