package com.oosca.practica2.ui.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oosca.practica2.R
import com.oosca.practica2.databinding.FragmentCatalogBinding

class CatalogFragment : Fragment() {

    private lateinit var binding: FragmentCatalogBinding
    private lateinit var actionToBook: CardView
    private lateinit var actionToNewBook: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionToBook = view.findViewById(R.id.cardView)
        actionToNewBook = view.findViewById(R.id.floatingActionButton)


        actionToBook.setOnClickListener {
            it.findNavController().navigate(R.id.bookFragment)
        }

        actionToNewBook.setOnClickListener {
            it.findNavController().navigate(R.id.newBookFragment)
        }
    }
}