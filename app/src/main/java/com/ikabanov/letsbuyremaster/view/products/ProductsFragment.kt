package com.ikabanov.letsbuyremaster.view.products

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ikabanov.letsbuyremaster.MainActivity
import com.ikabanov.letsbuyremaster.viewmodel.products.ProductsViewModel
import com.ikabanov.letsbuyremaster.R
import com.ikabanov.letsbuyremaster.databinding.FragmentProductsBinding
import com.ikabanov.letsbuyremaster.repository.Repository
import com.ikabanov.letsbuyremaster.repository.local.LocalMock
import com.ikabanov.letsbuyremaster.utils.Converter

class ProductsFragment : Fragment() {

    companion object {
        fun newInstance() = ProductsFragment()
    }

    private lateinit var viewModel: ProductsViewModel
    private lateinit var binding: FragmentProductsBinding
    private val dataSource: Repository = LocalMock
    private var editMode = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(inflater, container, false)

        val ctx = context
        if (ctx != null) {
            val products = dataSource.list()
            val adapter = ProductsAdapter(ctx, products)
            binding.productsList.adapter = adapter
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnGoToListsFromProducts.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_productsFragment_to_listsFragment)
        }

        binding.btnEditProducts.setOnClickListener {
            if (!editMode) {
                binding.btnEditProducts.text = getString(R.string.save)
                binding.productsList.visibility = ViewGroup.INVISIBLE
                binding.editTextProducts.visibility = ViewGroup.VISIBLE
                binding.editTextProducts.text = Editable.Factory.getInstance().newEditable(Converter.convertListToText(dataSource.list()))
            } else {
                binding.btnEditProducts.text = getString(R.string.edit)
                binding.productsList.visibility = ViewGroup.VISIBLE
                binding.editTextProducts.visibility = ViewGroup.INVISIBLE
                (binding.productsList.adapter as ProductsAdapter).products = Converter.convertTextToList(binding.editTextProducts.text.toString())
            }
            editMode = !editMode
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}