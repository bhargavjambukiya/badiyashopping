package com.app.badiyashopping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.badiyashopping.databinding.HomeProductRowBinding
import com.app.badiyashopping.databinding.ProductRowBinding
import com.app.badiyashopping.model.ProductModel


class ProductHomeAdapter(
    val products: MutableList<ProductModel>, val context: Context?
) :
    RecyclerView.Adapter<ProductHomeAdapter.ViewHolder>() {
    var onItemClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerRowBinding: HomeProductRowBinding =
            HomeProductRowBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(products[position].title, products[position].image)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ViewHolder(var recyclerRowBinding: HomeProductRowBinding) :
        RecyclerView.ViewHolder(recyclerRowBinding.root) {
        fun bindView(title: String?, image: Int?) {
            recyclerRowBinding.textViewProductName.text = title
            recyclerRowBinding.imageViewProduct.setImageResource(image!!)
        }

        init {
            recyclerRowBinding.textViewAdd.setOnClickListener {
                recyclerRowBinding.textViewAdd.visibility = View.GONE
                recyclerRowBinding.linearLayoutQty.visibility = View.VISIBLE
            }

            recyclerRowBinding.textViewQtyAdd.setOnClickListener {
                var qty: Int = Integer.parseInt(recyclerRowBinding.textViewQty.text.toString())
                qty++
                recyclerRowBinding.textViewQty.text = qty.toString()
            }
            recyclerRowBinding.textViewQtySub.setOnClickListener {
                var qty: Int = Integer.parseInt(recyclerRowBinding.textViewQty.text.toString())
                if (qty == 1) {
                    recyclerRowBinding.linearLayoutQty.visibility = View.GONE
                    recyclerRowBinding.textViewAdd.visibility = View.VISIBLE
                } else if (qty > 0) {
                    qty--
                    recyclerRowBinding.textViewQty.text = qty.toString()
                }

            }

            recyclerRowBinding.root.setOnClickListener {
                onItemClick?.invoke(adapterPosition)
            }
        }
    }

}