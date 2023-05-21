package com.oosca.dogtracker.ui.dog.tracker.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oosca.dogtracker.data.model.DogModel
import com.oosca.dogtracker.databinding.DogItemBinding

class DogRecyclerViewAdapter(private val clickListener: (DogModel) -> Unit)
    : RecyclerView.Adapter<DogRecyclerViewHolder>() {
    private val dogs = ArrayList<DogModel>()

    fun setData(dogList: List<DogModel>){
        dogs.clear()
        dogs.addAll(dogList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogRecyclerViewHolder {
        val binding = DogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dogs.size
    }

    override fun onBindViewHolder(holder: DogRecyclerViewHolder, position: Int) {
        val dog = dogs[position]
        holder.bind(dog, clickListener)
    }
}