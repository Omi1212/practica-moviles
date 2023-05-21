package com.oosca.practica2.ui.book.newbook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.oosca.practica2.databinding.FragmentNewBookBinding
import com.oosca.practica2.ui.book.viewmodel.BookViewModel

class NewBookFragment : Fragment() {

    private lateinit var binding: FragmentNewBookBinding

    private val bookViewModel: BookViewModel by activityViewModels {
        BookViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewBookBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = bookViewModel
    }

    private fun observeStatus(){
        bookViewModel.status.observe(viewLifecycleOwner) { status ->
            when{
                status.equals(BookViewModel.BOOK_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, bookViewModel.getBooks().toString())
                    bookViewModel.clearData()
                    bookViewModel.clearStatus()
                    findNavController().popBackStack()
                }
                status.equals(BookViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    bookViewModel.clearStatus()

                }
            }
        }
    }
    companion object{

        const val APP_TAG = "APP_TAG"
    }

}