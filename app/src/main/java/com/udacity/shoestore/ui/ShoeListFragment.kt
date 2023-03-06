package com.udacity.shoestore.ui

import android.app.LauncherActivity.ListItem
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
        binding.shoeListFragment = this@ShoeListFragment
        binding.lifecycleOwner = viewLifecycleOwner

        for (item in sharedViewModel.shoeList.value!!) {
            val listItemBinding = ListItemViewBinding.inflate(
                LayoutInflater.from(binding.shoeListLinearLayout.context),
                binding.shoeListLinearLayout,
                false
            )
            listItemBinding.shoeItem = item
            listItemBinding.lifecycleOwner = viewLifecycleOwner

            binding.shoeListLinearLayout.addView(
                listItemBinding.root
            )
        }

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
                val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
                findNavController().navigate(action)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun addShoe() {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        findNavController().navigate(action)
    }
}