package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ListItemViewBinding
import com.udacity.shoestore.viewmodels.SharedViewModel
import com.udacity.shoestore.viewmodels.SharedViewModelFactory

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val sharedViewModel: SharedViewModel by activityViewModels { SharedViewModelFactory() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        /*  OR, ALTERNATIVELY
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
         */
        binding.apply {
            shoeListFragment = this@ShoeListFragment        // layout variable
            lifecycleOwner = viewLifecycleOwner             // lifecycle owner
        }

        for (item in sharedViewModel.shoeList.value!!) {
            // Inflate the layout of the single item view
            val listItemBinding = ListItemViewBinding.inflate(
                LayoutInflater.from(binding.shoeListLinearLayout.context),
                binding.shoeListLinearLayout,
                false
            )
            listItemBinding.apply {
                shoeItem = item                             // single item layout variable
                lifecycleOwner = viewLifecycleOwner         // lifecycle owner
            }

            // Add the item view to the linear layout
            binding.shoeListLinearLayout.addView(
                listItemBinding.root
            )
        }

        // Enable the overflow menu
        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.shoe_list_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_option -> {
                // Log-out the user modifying the login status
                sharedViewModel.editLoginStatus()

                // Navigate to the login fragment (popping off the shoe list screen)
                val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
                findNavController().navigate(action)

                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    /**
     * Floating action button clicked: go to the details fragment
     */
    fun addShoe() {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        findNavController().navigate(action)
    }
}