package com.udacity.shoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.viewmodels.ShoeListViewModel


class DetailsFragment : Fragment() {
    private val viewModel : ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false
        )
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.saveButton.setOnClickListener {
            if(binding.shoeName.text.toString().isNotEmpty() &&
                binding.shoeSize.text.toString().isNotEmpty() &&
                binding.shoeCompanyName.text.toString().isNotEmpty() &&
                binding.description.text.toString().isNotEmpty()
                    ){
                viewModel.addShoe(
                    binding.shoeName.text.toString(),
                    binding.shoeSize.text.toString().toDouble(),
                    binding.shoeCompanyName.text.toString(),
                    binding.description.text.toString()
                )
            }
            it.findNavController().navigateUp()
        }

        return binding.root
    }

}