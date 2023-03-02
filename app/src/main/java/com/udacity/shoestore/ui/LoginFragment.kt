package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginFragment = this@LoginFragment
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    fun register() {
        if (!checkInputFiels())
            return

        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController().navigate(action)
    }

    fun login() {
        if (!checkInputFiels())
            return

        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController().navigate(action)
    }

    private fun checkInputFiels(): Boolean {
        binding.emailInputLayout.isErrorEnabled = false
        binding.passwordInputLayout.isErrorEnabled = false

        if (binding.emailEditText.text.isNullOrEmpty()) {
            binding.emailInputLayout.isErrorEnabled = true
            binding.emailInputLayout.error = "Empty value. Please, fill"
            return false
        }
        if (binding.passwordEditText.text.isNullOrEmpty()) {
            binding.passwordInputLayout.isErrorEnabled = true
            binding.passwordInputLayout.error = "Empty value. Please, fill"
            return false
        }

        return true
    }
}