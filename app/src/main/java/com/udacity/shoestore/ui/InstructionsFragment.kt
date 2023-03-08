package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionsBinding.inflate(inflater, container, false)
        /*  OR, ALTERNATIVELY
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
         */
        binding.apply {
            instructionsFragment = this@InstructionsFragment    // fragment layout variable
            lifecycleOwner = viewLifecycleOwner                 // lifecycle owner
        }

        return binding.root
    }


    /**
     * START button clicked: pop up inclusively the back stack to the login fragment, so that
     * there is no way for the user to get back to the boarding screens.
     * Then, open the shoe-list fragment
     */
    fun start() {
        val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
        findNavController().navigate(action)
    }
}