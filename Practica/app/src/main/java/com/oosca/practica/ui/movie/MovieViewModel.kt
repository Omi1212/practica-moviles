package com.oosca.practica.ui.movie

import android.text.Editable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.oosca.practica.MovieReviewerApplication
import com.oosca.practica.data.model.MovieModel
import com.oosca.practica.repositories.MovieRepository

class MovieViewModel (private val repository: MovieRepository): ViewModel(){
    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var calification = MutableLiveData("")
    var status = MutableLiveData("")


    fun getMovies()= repository.getMovies()

    fun addMovies(movie: MovieModel)=repository.addMovies(movie)

    fun createMovie() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val movie = MovieModel(
            name.value!!,
            category.value!!,
            description.value!!,
            calification.value!!
        )

        addMovies(movie)
        clearData()

        status.value = MOVIE_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrBlank() -> return false
            category.value.isNullOrBlank() -> return false
            description.value.isNullOrBlank() -> return false
            calification.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        category.value = ""
        description.value = ""
        calification.value = ""
    }

    fun setSelectedMovie(movie: MovieModel){
        name.value = movie.name
        category.value = movie.category
        description.value = movie.description
        calification.value = movie.calification
    }

    fun clearStatus(){
        status.value = INACTIVE
    }
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as  MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }


}