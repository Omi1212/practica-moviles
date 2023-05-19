package com.oosca.practica.repositories

import com.oosca.practica.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies()=movies
    fun addMovies(movie: MovieModel)=movies.add(movie)
}
