package com.oosca.dogtracker.ui.dog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oosca.dogtracker.R
import com.oosca.dogtracker.databinding.FragmentTrackerBinding

class TrackerFragment : Fragment() {

    private lateinit var actionToDog: CardView
    private lateinit var actionToNewDog: FloatingActionButton
    private lateinit var binding: FragmentTrackerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrackerBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionToDog = view.findViewById(R.id.cardView)
        actionToNewDog = view.findViewById(R.id.floatingActionButton)


        actionToDog.setOnClickListener {
            it.findNavController().navigate(R.id.action_trackerFragment_to_dogFragment)
        }

        actionToNewDog.setOnClickListener {
            it.findNavController().navigate(R.id.action_trackerFragment_to_newDogFragment)
        }
    }


}