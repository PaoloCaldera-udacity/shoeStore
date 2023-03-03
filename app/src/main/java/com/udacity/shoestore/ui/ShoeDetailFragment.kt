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
    private val sharedViewModel: SharedViewModel by activityViewModels {SharedViewModelFactory()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        binding.shoeDetailFragment = this@ShoeDetailFragment
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    fun cancel() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        findNavController().navigate(action)
    }

    fun save() {
        checkInputFields()
        sharedViewModel.addToList(
            name = binding.nameTextView.text.toString(),
            size = binding.sizeTextView.text.toString().toDouble(),
            company = binding.companyEditText.text.toString(),
            description = binding.descriptionEditText.text.toString()
        )
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        findNavController().navigate(action)
    }

    private fun checkInputFields(): Boolean {
        binding.nameInputLayout.isErrorEnabled = false
        binding.companyInputLayout.isErrorEnabled = false
        binding.sizeInputLayout.isErrorEnabled = false
        binding.descriptionInputLayout.isErrorEnabled = false

        if (binding.nameEditText.text.isNullOrEmpty()) {
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