package com.udacity.shoestore.screens.listing

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.viewmodels.LoginViewModel
import com.udacity.shoestore.viewmodels.ShoeListViewModel
import timber.log.Timber


class ListingFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listing, container, false
        )
        binding.addShoeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_listingFragment_to_detailsFragment)
        }



        viewModel.shoeList.observe(this as LifecycleOwner, Observer {

            for (shoe in viewModel.shoeList.value!!) {
                val inBinding = ShoeItemBinding.inflate(layoutInflater)
                inBinding.shoeData = shoe
                binding.listLayout.addView(inBinding.root)
            }
        })

        binding.addShoeButton.setOnClickListener {
            findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailsFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logOut -> navigate()

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navigate(): Boolean {
        loginViewModel.logOut()
        findNavController().navigate(ListingFragmentDirections.actionListingFragmentToLoginFragment())
        return false
    }


}