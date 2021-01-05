package com.app.badiyashopping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.badiyashopping.databinding.CategoryRowBinding
import com.app.badiyashopping.model.CategoryModel


class CategoryAdapter(
    val categoryList: List<CategoryModel>,
    val context: Context?
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    var onItemClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerRowBinding: CategoryRowBinding =
            CategoryRowBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(categoryList[position].title, categoryList[position].image)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class ViewHolder(var recyclerRowBinding: CategoryRowBinding) :
        RecyclerView.ViewHolder(recyclerRowBinding.root) {
        fun bindView(title: String?, image: Int) {
            recyclerRowBinding.textViewCategoryName.text = title
            recyclerRowBinding.imageViewProduct.setImageResource(image)
        }

        init {
            recyclerRowBinding.root.setOnClickListener {
                onItemClick?.invoke(adapterPosition)
            }
        }
    }

}