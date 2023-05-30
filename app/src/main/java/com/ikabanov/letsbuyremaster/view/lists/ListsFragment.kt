package com.ikabanov.letsbuyremaster.view.lists

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ikabanov.letsbuyremaster.MainActivity
import com.ikabanov.letsbuyremaster.viewmodel.lists.ListsViewModel
import com.ikabanov.letsbuyremaster.R
import com.ikabanov.letsbuyremaster.databinding.FragmentListsBinding

class ListsFragment : Fragment() {

    companion object {
        fun newInstance() = ListsFragment()
    }

    private lateinit var viewModel: ListsViewModel
    private lateinit var binding: FragmentListsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnGoToList.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_listsFragment_to_listFragment)
        }
        binding.btnGoToProducts.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_listsFragment_to_productsFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}