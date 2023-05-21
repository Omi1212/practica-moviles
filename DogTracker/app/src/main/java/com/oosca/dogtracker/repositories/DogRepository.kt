package com.oosca.dogtracker.repositories

import com.oosca.dogtracker.data.model.DogModel

class DogRepository(private val dogs: MutableList<DogModel>) {

    fun getDogs() = dogs
    fun addDogs(dog: DogModel) = dogs.add(dog)
}