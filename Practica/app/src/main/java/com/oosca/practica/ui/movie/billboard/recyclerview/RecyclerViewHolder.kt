package com.oosca.practica.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.oosca.practica.data.model.MovieModel
import com.oosca.practica.databinding.ListItemBinding

class RecyclerViewHolder (private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit){
        binding.textView7.text = movie.name
        binding.textView8.text = movie.calification
        binding.cardView.setOnClickListener{
            clickListener(movie)
        }
    }
}