package com.oosca.practica2.repository

import com.oosca.practica2.data.model.BookModel

class BookRepository(private val books: MutableList<BookModel>) {

    fun getBooks() = books
    fun addMBooks(book: BookModel) = books.add(book)
}