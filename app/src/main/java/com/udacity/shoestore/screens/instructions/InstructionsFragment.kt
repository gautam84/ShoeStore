package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_instructions, container, false
        )

        binding.nextButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_instructionsFragment_to_listingFragment)

        }

        return binding.root
    }

}