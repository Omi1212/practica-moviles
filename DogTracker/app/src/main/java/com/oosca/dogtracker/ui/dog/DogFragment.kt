package com.oosca.dogtracker.ui.dog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.oosca.dogtracker.R
import com.oosca.dogtracker.databinding.FragmentDogBinding
import com.oosca.dogtracker.ui.dog.viewmodel.DogViewModel

class DogFragment : Fragment() {

    private val viewModel: DogViewModel by activityViewModels{
        DogViewModel.Factory
    }

    private lateinit var binding: FragmentDogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDogBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

}