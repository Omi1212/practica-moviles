package com.oosca.dogtracker.data

import com.oosca.dogtracker.data.model.DogModel

val name = "Super Mario Brothers"
val category = "Animation"
val description = "Un fontanero llamado Mario viaja por un laberinto subterráneo con su hermano, Luigi, intentando salvar a una princesa capturada."
val qualification = "9.6"



val dogs = mutableListOf(
    DogModel(name, category, description, qualification)
)