package com.oosca.practica2.ui.book

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.oosca.practica2.BookReviewerApplication
import com.oosca.practica2.data.model.BookModel
import com.oosca.practica2.repository.BookRepository

class BookViewModel(private val repository: BookRepository) : ViewModel() {

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")


    fun getMovies() = repository.getBooks()
    fun addMovies(book: BookModel) = repository.addMBooks(book)

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createBook(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val newBooks = BookModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )

        addMovies(newBooks)
        clearData()
        status.value = BOOK_CREATED
    }
    fun clearStatus(){
        status.value = INACTIVE
    }

    fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BookReviewerApplication
                BookViewModel(app.bookRepository)
            }
        }

        const val BOOK_CREATED = "Book created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}