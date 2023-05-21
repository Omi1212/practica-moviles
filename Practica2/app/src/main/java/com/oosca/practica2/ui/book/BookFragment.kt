package com.oosca.practica2.ui.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oosca.practica2.R
import com.oosca.practica2.databinding.FragmentBookBinding

class BookFragment : Fragment() {
    private lateinit var binding: FragmentBookBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookBinding.inflate(inflater,container,false)
        return binding.root
    }

}