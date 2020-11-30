package com.udacity.shoestore.ui.fragments.shoe_store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoelistBinding
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoelist,
            container,
            false
        )


        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->


        })


        return binding.root
    }


}