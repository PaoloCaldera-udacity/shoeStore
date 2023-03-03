package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

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
        // Check if the fields have been compiled correctly
        // Call the viewModel method which adds a new shoe
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        findNavController().navigate(action)
    }
}