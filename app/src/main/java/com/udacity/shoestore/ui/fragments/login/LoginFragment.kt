package com.udacity.shoestore.ui.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )


        binding.btnLogin.setOnClickListener { view ->

            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnboardingFragment())
        }

        binding.btnRegister.setOnClickListener { view ->

            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnboardingFragment())
        }


        return binding.root
    }


}