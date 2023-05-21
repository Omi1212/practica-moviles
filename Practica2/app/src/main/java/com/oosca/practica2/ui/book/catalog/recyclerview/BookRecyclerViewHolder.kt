package com.oosca.practica2.ui.book.catalog.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.oosca.practica2.data.model.BookModel
import com.oosca.practica2.databinding.BookItemBinding

class BookRecyclerViewHolder (private val binding: BookItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(book: BookModel, clickListener: (BookModel) -> Unit){
        binding.textView2.text = book.name
        binding.textView3.text = book.qualification
        binding.cardView.setOnClickListener{
            clickListener(book)
        }
    }
}