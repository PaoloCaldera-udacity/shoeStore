package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
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

    /**
     * REGISTER button clicked
     */
    fun register() {
        if (!checkInputFiels())
            return

        val action = LoginFragmentDirections
            .actionLoginFragmentToWelcomeFragment(binding.emailEditText.text.toString())
        findNavController().navigate(action)
    }

    /**
     * LOGIN button clicked
     */
    fun login() {
        if (!checkInputFiels())
            return

        val action = LoginFragmentDirections
            .actionLoginFragmentToWelcomeFragment(binding.emailEditText.text.toString())
        findNavController().navigate(action)
    }


    /**
     * Checks the entries; in case they are null or empty, return false and
     * display an error message
     */
    //
    private fun checkInputFiels(): Boolean {
        binding.emailInputLayout.isErrorEnabled = false
        binding.passwordInputLayout.isErrorEnabled = false

        if (binding.emailEditText.text.isNullOrEmpty()) {
            // Highlight in red the email box and display the error message
            binding.emailInputLayout.isErrorEnabled = true
            binding.emailInputLayout.error = resources.getString(R.string.error_message)
            return false
        }

        if (binding.passwordEditText.text.isNullOrEmpty()) {
            // Highlight in red the password box and display the error message
            binding.passwordInputLayout.isErrorEnabled = true
            binding.passwordInputLayout.error = resources.getString(R.string.error_message)
            return false
        }

        return true
    }
}