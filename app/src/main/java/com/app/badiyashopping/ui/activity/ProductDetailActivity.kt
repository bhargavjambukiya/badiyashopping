package com.app.badiyashopping.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.badiyashopping.R
import com.app.badiyashopping.adapter.HomeCarouselAdapter
import com.app.badiyashopping.adapter.ProductHomeAdapter
import com.app.badiyashopping.databinding.ActivityProductDetailBinding
import com.app.badiyashopping.model.ProductModel


class ProductDetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityProductDetailBinding
    var qty = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeComponent()
    }

    private fun initializeComponent() {
        binding.imageViewBack.setOnClickListener { finish() }

        setupProductCarousel()
        setupRelatedProduct()
        binding.textViewAdd.setOnClickListener(this)
        binding.textViewQtyAdd.setOnClickListener(this)
        binding.textViewQtySub.setOnClickListener(this)
    }

    private fun setupProductCarousel() {
        val carouselList =
            mutableListOf(
                R.drawable.carousel1,
                R.drawable.carousel2,
                R.drawable.carousel4,
                R.drawable.carousel3
            )
        val carouselAdapter = HomeCarouselAdapter(carouselList, this)
        binding.viewPagerProductImage.adapter = carouselAdapter
        binding.indicator.setViewPager(binding.viewPagerProductImage)
    }

    private fun setupRelatedProduct() {
        val product = ProductModel(title = "Apple", image = R.drawable.apple)
        val product1 = ProductModel(title = "Broccoli", image = R.drawable.brocoli)
        val product2 = ProductModel(title = "Brinjal", image = R.drawable.brinjal)
        val product3 = ProductModel(title = "banana", image = R.drawable.banana)
        val product4 = ProductModel(title = "orange", image = R.drawable.orange)

        val productsModelList = mutableListOf(product, product1, product2, product3, product4)
        val adapterProduct = ProductHomeAdapter(productsModelList, this)
        binding.recyclerViewRelatedProducts.adapter = adapterProduct;
        adapterProduct.onItemClick = {
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onClick(v: View?) {
        val viewId = v?.id
        when (viewId) {
            R.id.textViewAdd -> displayQty()
            R.id.textViewQtySub -> {
                if (qty > 1) {
                    qty = Integer.parseInt(binding.textViewQty.text.toString())
                    qty--
                    binding.textViewQty.text = qty.toString()
                } else {
                    binding.textViewAdd.visibility = View.VISIBLE
                    binding.linearLayoutQty.visibility = View.INVISIBLE
                }
            }
            R.id.textViewQtyAdd -> {
                qty = Integer.parseInt(binding.textViewQty.text.toString())
                qty++
                binding.textViewQty.text = qty.toString()
                Log.e("Qty",binding.textViewQty.text.toString())
            }
        }
    }

    private fun displayQty() {
        binding.textViewAdd.visibility = View.GONE
        binding.linearLayoutQty.visibility = View.VISIBLE
        qty = Integer.parseInt(binding.textViewQty.text.toString())
        binding.textViewQty.text = qty.toString()
    }
}