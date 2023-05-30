package com.ikabanov.letsbuyremaster.view.lists

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ikabanov.letsbuyremaster.MainActivity
import com.ikabanov.letsbuyremaster.viewmodel.lists.ListViewModel
import com.ikabanov.letsbuyremaster.R
import com.ikabanov.letsbuyremaster.databinding.FragmentListBinding
import com.ikabanov.letsbuyremaster.databinding.FragmentProductsBinding

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnGoToListsFromList.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_listFragment_to_listsFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}