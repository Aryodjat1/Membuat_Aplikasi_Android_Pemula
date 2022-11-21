package com.djatscode.kotlin.dicodingsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        val intent: Bundle? = intent.extras
        val aTitle = intent?.getString("title")
        val aDesc = intent?.getString("desc")
        val aGenre = intent?.getString("genre")
        val aRating = intent?.getDouble("rating", 0.0)
        val aPhoto = intent?.getInt("photo", 0)

        val dtlPhoto: ImageView = findViewById(R.id.img_dtl_photo)
        val dtlTitle: TextView = findViewById(R.id.tv_dtl_title)
        val dtlGenre: TextView = findViewById(R.id.tv_dtl_genre)
        val dtlRate: TextView = findViewById(R.id.tv_dtl_rating)
        val dtlDesc: TextView = findViewById(R.id.tv_dtl_desc)

        dtlTitle.text = aTitle
        dtlGenre.text = aGenre
        dtlRate.text = aRating.toString()
        dtlDesc.text = aDesc
        Glide.with(this)
            .load(aPhoto)
            .apply(RequestOptions().override(55, 55))
            .into(dtlPhoto)
    }
}