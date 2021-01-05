package com.app.badiyashopping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.app.badiyashopping.R
import java.util.*


class HomeCarouselAdapter(
    private val images: List<Int>,
    val context: Context?
) : PagerAdapter() {
    private var mLayoutInflater: LayoutInflater? = null
    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as CardView
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        mLayoutInflater =
            context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val itemView: View =
            mLayoutInflater!!.inflate(R.layout.home_carousel_item, container, false)
        val imageView: ImageView = itemView.findViewById<View>(R.id.imageViewCarousel) as ImageView

        imageView.setImageResource(images[position])

        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}