package com.example.niaflix2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var rateTextView: TextView
    private lateinit var rateCountTextView: TextView
    private lateinit var releaseDateTextView: TextView
    private lateinit var overviewTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        rateTextView = findViewById(R.id.mediaRate)
        rateCountTextView = findViewById(R.id.mediaRateCount)
        releaseDateTextView = findViewById(R.id.mediaReleaseDate)
        overviewTextView = findViewById(R.id.mediaOverview)


        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie


        titleTextView.text = movie.title.toString()
        rateTextView.text = "Rating : " + movie.vote.toString()
        rateCountTextView.text = "Total Rates: " + movie.count.toString()
        releaseDateTextView.text = "Date Released: " + movie.release_date
        overviewTextView.text = "Synopsis: " + movie.overview


        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
            .into(mediaImageView)


    }
}