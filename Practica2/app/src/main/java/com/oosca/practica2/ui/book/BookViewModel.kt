package com.oosca.practica2.ui.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.oosca.practica2.BookReviewerApplication
import com.oosca.practica2.data.model.BookModel
import com.oosca.practica2.repository.BookRepository

class BookViewModel(private val repository: BookRepository) : ViewModel() {
    fun getMovies() = repository.getBooks()
    fun addMovies(book: BookModel) = repository.addMBooks(book)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookReviewerApplication
                BookViewModel(app.bookRepository)
            }
        }
    }
}