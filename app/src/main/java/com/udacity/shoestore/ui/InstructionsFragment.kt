package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        binding = FragmentInstructionsBinding.inflate(inflater, container, false)
        binding.instructionsFragment = this@InstructionsFragment
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    fun start() {
        findNavController().popBackStack(R.id.loginFragment, true)
        findNavController().navigate(R.id.shoeListFragment)
    }
}