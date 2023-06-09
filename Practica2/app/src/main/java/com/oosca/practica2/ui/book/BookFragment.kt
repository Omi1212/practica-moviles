package com.oosca.practica2.ui.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.oosca.practica2.R
import com.oosca.practica2.databinding.FragmentBookBinding
import com.oosca.practica2.ui.book.viewmodel.BookViewModel

class BookFragment : Fragment() {

    private val viewModel: BookViewModel by activityViewModels{
        BookViewModel.Factory
    }
    private lateinit var binding: FragmentBookBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookBinding.inflate(inflater,container,false)
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