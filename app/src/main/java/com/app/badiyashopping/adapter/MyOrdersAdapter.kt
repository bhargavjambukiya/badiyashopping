package com.app.badiyashopping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.badiyashopping.databinding.CartRowBinding
import com.app.badiyashopping.databinding.MyOrderRowBinding
import com.app.badiyashopping.databinding.ProductRowBinding
import com.app.badiyashopping.model.ProductModel


class MyOrdersAdapter(
    val products: MutableList<ProductModel>, val context: Context?
) :
    RecyclerView.Adapter<MyOrdersAdapter.ViewHolder>() {
    var onItemClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerRowBinding: MyOrderRowBinding =
            MyOrderRowBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(products[position].title, products[position].image)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ViewHolder(var recyclerRowBinding: MyOrderRowBinding) :
        RecyclerView.ViewHolder(recyclerRowBinding.root) {
        fun bindView(title: String?, image: Int?) {

        }

        init {
            recyclerRowBinding.root.setOnClickListener {
                onItemClick?.invoke(adapterPosition)
            }
        }
    }

}