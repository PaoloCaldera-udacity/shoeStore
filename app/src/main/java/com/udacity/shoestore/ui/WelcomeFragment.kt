package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var args: WelcomeFragmentArgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get navigation arguments from bundle
        args = WelcomeFragmentArgs.fromBundle(requireArguments())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.welcomeFragment = this@WelcomeFragment
        binding.lifecycleOwner = viewLifecycleOwner

        // Insert user email in welcome sentence
        binding.welcomeTextView.text = resources.getString(R.string.welcome_text, args.userEmail)

        return binding.root
    }


    /**
     * READ INSTRUCTIONS button clicked
     */
    fun readInstructions() {
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
        findNavController().navigate(action)
    }
}