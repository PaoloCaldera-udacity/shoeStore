package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewmodels.SharedViewModel
import com.udacity.shoestore.viewmodels.SharedViewModelFactory

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val sharedViewModel: SharedViewModel by activityViewModels { SharedViewModelFactory() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        /*  OR, ALTERNATIVELY
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
         */
        binding.apply {
            shoeDetailFragment = this@ShoeDetailFragment        // fragment layout variable
            viewModel = sharedViewModel                         // viewModel layout variable
            lifecycleOwner = viewLifecycleOwner                 // lifecycle owner
        }

        return binding.root
    }


    /**
     * CANCEL button clicked: pop to the shoe-list fragment
     */
    fun cancel() {
        sharedViewModel.backToList()
        findNavController().popBackStack()
    }

    /**
     * SAVE button clicked: check the input fields, add the shoe item to the list and then
     * pop to the shoe-list fragment to go back
     */
    fun save() {
        if (!checkInputFields())
            return

        sharedViewModel.addToList()
        findNavController().popBackStack()
    }


    /**
     * Checks the entries; in case they are null or empty, return false and
     * display an error message
     */
    private fun checkInputFields(): Boolean {
        binding.nameInputLayout.isErrorEnabled = false
        binding.companyInputLayout.isErrorEnabled = false
        binding.sizeInputLayout.isErrorEnabled = false
        binding.descriptionInputLayout.isErrorEnabled = false

        if (binding.nameEditText.text.isNullOrEmpty()) {
            // Highlight in red the email box and display the error message
            binding.nameInputLayout.isErrorEnabled = true
            binding.nameInputLayout.error = resources.getString(R.string.error_message)
            return false
        }
        if (binding.companyEditText.text.isNullOrEmpty()) {
            binding.companyInputLayout.isErrorEnabled = true
            binding.companyInputLayout.error = resources.getString(R.string.error_message)
            return false
        }
        if (binding.sizeEditText.text.isNullOrEmpty()) {
            binding.sizeInputLayout.isErrorEnabled = true
            binding.sizeInputLayout.error = resources.getString(R.string.error_message)
            return false
        }
        if (binding.descriptionEditText.text.isNullOrEmpty()) {
            binding.descriptionInputLayout.isErrorEnabled = true
            binding.descriptionInputLayout.error = resources.getString(R.string.error_message)
            return false
        }

        return true
    }
}