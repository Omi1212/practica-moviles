package com.oosca.dogtracker.ui.dog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.oosca.dogtracker.R
import com.oosca.dogtracker.databinding.FragmentNewDogBinding

class NewDogFragment : Fragment() {
    private val dogViewModel: DogViewModel by activityViewModels {
        DogViewModel.Factory
    }
    lateinit var binding: FragmentNewDogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewDogBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = dogViewModel
    }

    private fun observeStatus(){
        dogViewModel.status.observe(viewLifecycleOwner) { status ->
            when{
                status.equals(DogViewModel.DOG_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, dogViewModel.getDogs().toString())
                    dogViewModel.clearData()
                    dogViewModel.clearStatus()
                    findNavController().popBackStack()
                }
                status.equals(DogViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    dogViewModel.clearStatus()

                }
            }
        }
    }
    companion object{

        const val APP_TAG = "APP_TAG"
    }


}