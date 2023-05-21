package com.oosca.dogtracker.ui.dog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.oosca.dogtracker.DogReviewerApplication
import com.oosca.dogtracker.data.model.DogModel
import com.oosca.dogtracker.repositories.DogRepository

class DogViewModel(private val repository: DogRepository) : ViewModel() {

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")
    fun getDogs() = repository.getDogs()
    fun addDogs(dog: DogModel) = repository.addDogs(dog)

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createDog(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val newDogs = DogModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )

        addDogs(newDogs)
        clearData()
        status.value = DOG_CREATED
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
                val app = this[APPLICATION_KEY] as DogReviewerApplication
                DogViewModel(app.dogRepository)
            }
        }

        const val DOG_CREATED = "Dog created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}