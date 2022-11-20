package com.djatscode.kotlin.dicodingsubmission

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.ArrayList

class ListMovieAdapter(private val listMovies: ArrayList<Movie>, val context: Context) : RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = listMovies[position]

        Glide.with(holder.itemView.context)
            .load(movie.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvTitle.text = movie.title
        holder.tvDesc.text = movie.desc
        holder.tvGenre.text = movie.genre
        holder.tvRating.text = movie.rating.toString()

        holder.itemView.setOnClickListener {
            val gTitle : String = movie.title
            val gGenre : String = movie.genre
            val gRating : Double = movie.rating
            val gDesc : String = movie.desc
            val gPhoto : Int = movie.photo

            val intent = Intent(context, DetailPage::class.java)
            intent.putExtra("title", gTitle)
            intent.putExtra("genre", gGenre)
            intent.putExtra("rating", gRating)
            intent.putExtra("desc", gDesc)
            intent.putExtra("photo", gPhoto)

            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        var tvDesc: TextView = itemView.findViewById(R.id.tv_item_desc)
        var tvGenre: TextView = itemView.findViewById(R.id.tv_item_genre)
        var tvRating: TextView = itemView.findViewById(R.id.tv_item_rating)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }
}