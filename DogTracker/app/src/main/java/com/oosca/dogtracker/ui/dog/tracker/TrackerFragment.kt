package com.oosca.dogtracker.ui.dog.tracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oosca.dogtracker.R
import com.oosca.dogtracker.data.model.DogModel
import com.oosca.dogtracker.databinding.FragmentTrackerBinding
import com.oosca.dogtracker.ui.dog.tracker.recyclerview.DogRecyclerViewAdapter
import com.oosca.dogtracker.ui.dog.viewmodel.DogViewModel

class TrackerFragment : Fragment() {

    private val dogViewModel: DogViewModel by activityViewModels {
        DogViewModel.Factory
    }

    private lateinit var adapter: DogRecyclerViewAdapter
    lateinit var binding: FragmentTrackerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener{
            dogViewModel.clearData()
            it.findNavController().navigate(R.id.action_trackerFragment_to_newDogFragment)
        }
    }

    private fun setRecyclerView(view:View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = DogRecyclerViewAdapter { selectedDog ->
            showSelectedItem(selectedDog)
        }

        binding.recyclerView.adapter = adapter
        displayMovie()
    }


    private fun showSelectedItem(dog: DogModel){
        dogViewModel.setSelectedDog(dog)
        findNavController().navigate(R.id.action_trackerFragment_to_dogFragment)
    }

    private fun displayMovie(){
        adapter.setData(dogViewModel.getDogs())
        adapter.notifyDataSetChanged()
    }



}