package com.djatscode.kotlin.dicodingsubmission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMovieAdapter(private val listMovie: ArrayList<Movie>) : RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_Title)
        var tvGenre: TextView = itemView.findViewById(R.id.tv_Genre)
        var tvRating: TextView = itemView.findViewById(R.id.tv_Rating)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_Description)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_Photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = listMovie[position]

        Glide.with(holder.itemView.context)
            .load(movie.photo)
            .apply(RequestOptions().override(125, 125))
            .into((holder.imgPhoto))

        holder.tvTitle.text = movie.title
        holder.tvGenre.text = movie.genre
        holder.tvRating.text = movie.rating.toString()
        holder.tvDescription.text = movie.description
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }
}