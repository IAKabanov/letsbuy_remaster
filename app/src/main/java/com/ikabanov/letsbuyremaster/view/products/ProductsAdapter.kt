package com.ikabanov.letsbuyremaster.view.products

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ikabanov.letsbuyremaster.R
import com.ikabanov.letsbuyremaster.data.ProductModel
import com.ikabanov.letsbuyremaster.databinding.ProductItemBinding

class ProductsAdapter() : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    private lateinit var inflater: LayoutInflater
    var products = listOf<ProductModel>()

    constructor(context: Context, products: List<ProductModel>) : this() {
        this.products = products
        this.inflater = LayoutInflater.from(context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.productName.text = product.name
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productName: TextView

        init {
            val binding: ProductItemBinding = ProductItemBinding.bind(itemView)
            productName = binding.productName
        }
    }

}