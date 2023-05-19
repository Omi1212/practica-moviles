package com.oosca.practica.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oosca.practica.R
import com.oosca.practica.data.model.MovieModel
import com.oosca.practica.databinding.FragmentBillboardBinding
import com.oosca.practica.ui.movie.MovieViewModel
import com.oosca.practica.ui.movie.billboard.recyclerview.RecyclerViewAdapter



class BillboardFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBillboardBinding.inflate(inflater,container,false)
        return binding.root
    }

    lateinit var binding: FragmentBillboardBinding
    private lateinit var adapter: RecyclerViewAdapter

    private fun showSelectedItem(movie: MovieModel){
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }
    private fun displayMovie(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view:View){
        binding.Recycler.layoutManager = LinearLayoutManager(view.context)

        adapter = RecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.Recycler.adapter = adapter
        displayMovie()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener{
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
    }

}