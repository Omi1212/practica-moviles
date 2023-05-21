package com.oosca.practica2.ui.book.catalog.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oosca.practica2.data.model.BookModel
import com.oosca.practica2.databinding.BookItemBinding

class BookRecyclerViewAdapter(private val clickListener: (BookModel) -> Unit)
    : RecyclerView.Adapter<BookRecyclerViewHolder>() {
    private val books = ArrayList<BookModel>()

    fun setData(booksList: List<BookModel>){
        books.clear()
        books.addAll(booksList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookRecyclerViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookRecyclerViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book, clickListener)
    }
}