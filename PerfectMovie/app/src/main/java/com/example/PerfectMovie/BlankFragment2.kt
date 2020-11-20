package com.example.bottomnav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.onedataelement.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private val Consturl: String = "https://api.themoviedb.org/3/movie/upcoming?api_key="

class BlankFragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var top: Tops

    private var items: MutableList<ModelData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        top = Tops(Consturl+"${BuildConfig.API_KEY}"+"&language=en-US&page=1")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        updateRecycler()
        settingRecycler()
    }

    fun clearRecycler() {
        Recycler.recycledViewPool.clear()
        items.clear()
    }

    fun updateItems() {

        for (count in 1..top.getCount()) {
            items.add(ModelData(top.getTitle(count - 1), "https://image.tmdb.org/t/p/w200/" + top.getUrlToImage(count - 1), top.getvote_average(count - 1), top.getRealeaseDate(count - 1), top.getOverview(count -1)))
        }
    }

    fun updateRecycler() {
        clearRecycler()
        updateItems()
    }

    fun settingRecycler() {
        Recycler.layoutManager = LinearLayoutManager(this.context)
        Recycler.setHasFixedSize(true)
        Recycler.adapter = RecyclerAdapter(/*this,*/ items, false){

            val intent : Intent = Intent(this.context, thiselement::class.java)
            intent.putExtra("OBJECT", it)
            startActivity(intent)
            Animatoo.animateDiagonal(this.context)
        }
    }
}