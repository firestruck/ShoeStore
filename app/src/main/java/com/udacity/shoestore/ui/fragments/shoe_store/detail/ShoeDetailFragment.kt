package com.udacity.shoestore.ui.fragments.shoe_store.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewmodels.ShoeListViewModel


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel.asEmptyField.observe(viewLifecycleOwner, { isEmpty ->
            if (isEmpty) {

                Snackbar.make(requireView(), R.string.missing_fields, Snackbar.LENGTH_SHORT)
                    .setTextColor(
                        ContextCompat.getColor(requireContext(), R.color.design_default_color_error)
                    )
                    .show()
            }
        })

        viewModel.navigate2List.observe(viewLifecycleOwner, { saveShoe ->
            if (saveShoe) {
                findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeFragment)
                viewModel.onNavigateComplete()
            }
        })



        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )


        binding.shoeViewModel = viewModel



        binding.btnCancel.setOnClickListener { view ->
            viewModel.resetForm()
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeFragment)
        }


        return binding.root
    }


}