package com.app.badiyashopping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.badiyashopping.databinding.CategoryRowBinding
import com.app.badiyashopping.databinding.HomeCategoryRowBinding
import com.app.badiyashopping.model.CategoryModel


class HomeCategoryAdapter(
    val categoryList: List<CategoryModel>,
    val context: Context?
) :
    RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder>() {
    var onItemClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerRowBinding: HomeCategoryRowBinding =
            HomeCategoryRowBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(categoryList[position].title, categoryList[position].image)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class ViewHolder(var recyclerRowBinding: HomeCategoryRowBinding) :
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