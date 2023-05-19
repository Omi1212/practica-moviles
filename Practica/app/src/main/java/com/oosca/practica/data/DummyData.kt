package com.oosca.practica.data

import com.oosca.practica.data.model.MovieModel

val name = "Super Mario Brothers"
val category = "Animation"
val description = "Un fontanero llamado Mario viaja por un laberinto subterráneo con su hermano, Luigi, intentando salvar a una princesa capturada."
val calification = "9.6"


val movies = mutableListOf(
MovieModel(name, category, description, calification)
)