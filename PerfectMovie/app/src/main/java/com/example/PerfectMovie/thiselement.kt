package com.example.bottomnav


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat.animate
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_thiselement.*
import java.lang.Exception


class thiselement : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thiselement)

        val item : ModelData? = intent.getParcelableExtra<ModelData>("OBJECT")

        Picasso.get().load(item?.urlToImage).fit().placeholder(R.drawable.black).error(R.drawable.black).into(ImageFilm, object :
            Callback {
            override fun onSuccess(){
                Progress_bar.visibility = View.INVISIBLE
            }
            override fun onError(e: Exception){

            }
        })

        TitleFilm.text = "Название фильма: " + item?.title

        Vote_average.text = "Оценка фильма: " + item?.vote_average

        Release_date.text = "Дата выхода: " + item?.release_date

        Overview.text = "Описание фильма: " + item?.overview

    }

    override fun onBackPressed() {
        super.onBackPressed()
        Animatoo.animateSwipeRight(this)
    }

}
