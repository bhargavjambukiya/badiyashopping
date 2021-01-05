package com.app.badiyashopping.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.app.badiyashopping.R
import com.app.badiyashopping.adapter.HomeCarouselAdapter
import com.app.badiyashopping.databinding.ActivityProductDetailBinding


class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    var currentPage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeComponent()
    }

    private fun initializeComponent() {
        binding.imageViewBack.setOnClickListener { finish() }

        val carouselList =
            mutableListOf(
                R.drawable.carousel1,
                R.drawable.carousel2,
                R.drawable.carousel4,
                R.drawable.carousel3
            )
        val carouselAdapter = HomeCarouselAdapter(carouselList, this)
        binding.viewPagerProductImage.adapter = carouselAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPagerProductImage, true)

    }
}