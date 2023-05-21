package com.oosca.dogtracker.ui.dog.tracker.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.oosca.dogtracker.data.model.DogModel
import com.oosca.dogtracker.databinding.DogItemBinding

class DogRecyclerViewHolder (private val binding: DogItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(dog: DogModel, clickListener: (DogModel) -> Unit){
        binding.textView2.text = dog.name
        binding.textView3.text = dog.qualification
        binding.cardView.setOnClickListener{
            clickListener(dog)
        }
    }
}