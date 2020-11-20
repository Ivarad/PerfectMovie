package com.example.bottomnav


import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_QUICK_VIEW
import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.onedataelement.*
import java.lang.Exception

class RecyclerAdapter( val item : MutableList<ModelData>, val fragmentfirst : Boolean ,val listener: (ModelData) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.MainHolder>() {

    private var show : Boolean = fragmentfirst

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.onedataelement, parent, false))

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: RecyclerAdapter.MainHolder, position: Int) {
        holder.bind(item.get(position))
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val ImageFilm : ImageView = itemView.findViewById(R.id.ImageFilm)


        private val Title_Film : TextView = itemView.findViewById(R.id.TitleFilm)

        private val Vote_average_Film : TextView = itemView.findViewById(R.id.Vote_average)

        private val Release_date : TextView = itemView.findViewById(R.id.Release_date)

        private val Progress_bar : ProgressBar = itemView.findViewById(R.id.Progress_bar)

        fun bind(item : ModelData) {
            Picasso.get().load(item.urlToImage).fit().placeholder(R.drawable.black).error(R.drawable.black).into(ImageFilm, object : Callback{
                override fun onSuccess(){
                    Progress_bar.visibility = View.INVISIBLE
                }
                override fun onError(e: Exception){

                }
            })


            Title_Film.text = "Название фильма: " + item.title

            Vote_average_Film.text = "Оценки фильма: " + item.vote_average

            Release_date.text = "Дата выхода: " + item.release_date

            itemView.setOnClickListener{listener(item)}
            if (show){
                Release_date.visibility = View.GONE
            }
            else{
                Release_date.visibility = View.VISIBLE
            }

        }

    }
}