package com.udacity.shoestore.ui.fragments.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding


class IntructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instructions,
            container,
            false
        )

        binding.btnGoShop.setOnClickListener {


            findNavController().navigate(IntructionsFragmentDirections.actionIntructionsFragmentToShoeFragment())
        }


        return binding.root
    }


}