package com.oosca.practica.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oosca.practica.data.model.MovieModel
import com.oosca.practica.databinding.ListItemBinding

class RecyclerViewAdapter(private val clickListener: (MovieModel) -> Unit)
    : RecyclerView.Adapter<RecyclerViewHolder>() {
    private val movies = ArrayList<MovieModel>()

    fun setData(moviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(moviesList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }
}