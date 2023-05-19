package com.oosca.practica

import android.app.Application
import com.oosca.practica.data.movies
import com.oosca.practica.repositories.MovieRepository

class MovieReviewerApplication: Application() {
val movieRepository: MovieRepository by lazy {
    MovieRepository(movies)
}
}