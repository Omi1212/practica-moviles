package com.oosca.practica2.data

import com.oosca.practica2.data.model.BookModel

val name = "Super Mario Brothers"
val category = "Animation"
val description = "Un fontanero llamado Mario viaja por un laberinto subterráneo con su hermano, Luigi, intentando salvar a una princesa capturada."
val qualification = "9.6"



val books = mutableListOf(
    BookModel(name, category, description, qualification)
)