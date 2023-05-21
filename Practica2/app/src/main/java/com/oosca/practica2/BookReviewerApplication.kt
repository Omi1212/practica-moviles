package com.oosca.practica2

import android.app.Application
import com.oosca.practica2.data.books
import com.oosca.practica2.repository.BookRepository

class BookReviewerApplication : Application() {
    val bookRepository: BookRepository by lazy {
        BookRepository(books)
    }
}