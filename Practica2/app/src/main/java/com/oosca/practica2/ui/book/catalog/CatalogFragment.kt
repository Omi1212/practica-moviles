package com.oosca.practica2.ui.book.catalog

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
import com.oosca.practica2.R
import com.oosca.practica2.data.model.BookModel
import com.oosca.practica2.databinding.FragmentCatalogBinding
import com.oosca.practica2.ui.book.catalog.recyclerview.BookRecyclerViewAdapter
import com.oosca.practica2.ui.book.viewmodel.BookViewModel

class CatalogFragment : Fragment() {

    private val bookViewModel: BookViewModel by activityViewModels {
        BookViewModel.Factory
    }

    private lateinit var adapter: BookRecyclerViewAdapter
    lateinit var binding: FragmentCatalogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatalogBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener{
            bookViewModel.clearData()
            it.findNavController().navigate(R.id.action_catalogFragment_to_newBookFragment)
        }
    }

    private fun setRecyclerView(view:View){
        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)

        adapter = BookRecyclerViewAdapter { selectedBook ->
            showSelectedItem(selectedBook)
        }

        binding.recyclerview.adapter = adapter
        displayMovie()
    }


    private fun showSelectedItem(book: BookModel){
        bookViewModel.setSelectedBook(book)
        findNavController().navigate(R.id.action_catalogFragment_to_bookFragment)
    }

    private fun displayMovie(){
        adapter.setData(bookViewModel.getBooks())
        adapter.notifyDataSetChanged()
    }
}