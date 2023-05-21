package com.oosca.dogtracker.ui.dog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oosca.dogtracker.R
import com.oosca.dogtracker.databinding.FragmentDogBinding

class DogFragment : Fragment() {

    lateinit var binding: FragmentDogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogBinding.inflate(inflater,container,false)
        return binding.root
    }

}