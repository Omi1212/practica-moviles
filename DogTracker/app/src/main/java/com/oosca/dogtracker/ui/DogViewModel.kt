package com.oosca.dogtracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.oosca.dogtracker.DogReviewerApplication
import com.oosca.dogtracker.data.model.DogModel
import com.oosca.dogtracker.repositories.DogRepository

class DogViewModel(private val repository: DogRepository) : ViewModel() {
    fun getDogs() = repository.getDogs()
    fun addDogs(dog: DogModel) = repository.addDogs(dog)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as DogReviewerApplication
                DogViewModel(app.dogRepository)
            }
        }
    }
}