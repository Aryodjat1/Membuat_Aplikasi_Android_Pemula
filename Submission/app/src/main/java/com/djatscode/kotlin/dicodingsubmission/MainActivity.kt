package com.djatscode.kotlin.dicodingsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMovies: RecyclerView
//    private var list: ArrayList<Movie> = arrayListOf()
    private var list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_Movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(MoviesData.listData)
        showRecylerList()
    }

    private fun showRecylerList(){
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovies.adapter = listMovieAdapter
    }
}