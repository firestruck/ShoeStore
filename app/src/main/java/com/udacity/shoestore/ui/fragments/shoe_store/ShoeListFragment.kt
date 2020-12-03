package com.udacity.shoestore.ui.fragments.shoe_store

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeListViewModel
import java.lang.StringBuilder


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoelistBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->

            for (shoe in shoeList) {

                binding.llShoeList.addView(addShoeTxt(shoe))
            }

        })



        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoelist,
            container,
            false
        )


        binding.shoeViewModel = viewModel
        setHasOptionsMenu(true)



        binding.fabAddShoe.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_shoeFragment_to_shoeDetailFragment)
        }

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu_item, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    fun addShoeTxt(shoe: Shoe): TextView {
        val shoeTextView = TextView(context, null, 0, R.style.list)
        val name = shoe.name
        val size = shoe.size.toString()
        val company = shoe.company
        val description = shoe.description

        val strb = StringBuilder()
        strb.append("Name: $name\n")
        strb.append("Size: $size\n")
        strb.append("Company: $company\n")
        strb.append("Descrition: $description")
        shoeTextView.text = strb.toString()
        return shoeTextView
    }
}
