package com.example.niaflix2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "MovieAdapter"

class ArticleAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val article = movies[position]
        holder.bind(article)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.mediaImage)
        private val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle)
        private val rateTextView = itemView.findViewById<TextView>(R.id.mediaRate)

        init {
            itemView.setOnClickListener(this)
        }



        override fun onClick(v: View?) {

            val article = movies[absoluteAdapterPosition]

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, article)
            context.startActivity(intent)
        }

        fun bind(article: Movie) {
            titleTextView.text = article.title.toString()
            rateTextView.text = "Rating: " + article.vote.toString()

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + article.poster_path)
                .into(mediaImageView)
        }
    }
}