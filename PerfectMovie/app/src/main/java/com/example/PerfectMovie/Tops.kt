package com.example.bottomnav

import android.util.Log
import com.example.PerfectMovie.ApiInterface
import okhttp3.*
import org.json.JSONObject

class Tops(url : String) : ApiInterface {
    override var list_vote_average: MutableList<String>  = mutableListOf<String>()
    override var listrelease_date: MutableList<String>  = mutableListOf<String>()
    override var listoverview: MutableList<String>  = mutableListOf<String>()
    override var listUrlsOfImage: MutableList<String>  = mutableListOf<String>()
    override var listTitles: MutableList<String>  = mutableListOf<String>()
    override var countFilms : Int = 0

    override var jsonurl: String = url

    init{
        getInfo()
    }

    override fun getCount(): Int {
        return countFilms
    }

    override fun getTitle(index: Int): String {
        return listTitles.get(index)
    }

    override fun getvote_average(index: Int): String {
        return list_vote_average.get(index)
    }

    override fun getUrlToImage(index: Int): String {
        return listUrlsOfImage.get(index)
    }

    override fun getOverview(index: Int): String {
        return listoverview.get(index)
    }

    override fun getRealeaseDate(index: Int): String {
        return listrelease_date.get(index)
    }

    override fun clearList() {
        list_vote_average.clear()
        listoverview.clear()
        listTitles.clear()
        listUrlsOfImage.clear()
        listrelease_date.clear()

        countFilms = 0
    }

    override fun getInfo() {
        val httpClient : OkHttpClient = OkHttpClient()

        var json : String = ""

        val request : Request = Request.Builder().url(jsonurl).build()

        val response : Response = httpClient.newCall(request).execute()

        if(response.isSuccessful) {
            json = response.body!!.string()
        }
        else {
            json = "{'results': [{'vote_average': null, 'title': null, 'overview': null, 'poster_path': null, 'release_date': null}]}"
        }

        Log.d("DEBUG", json)

        clearList()

        val count : Int = (JSONObject(json).getJSONArray("results").length())

        Log.d("DEBUG", count.toString())

        for(count2 in 1..count)
        {
            list_vote_average.add((JSONObject(json).getJSONArray("results").getJSONObject(count2 - 1)).get("vote_average").toString())
            listoverview.add((JSONObject(json).getJSONArray("results").getJSONObject(count2 - 1)).get("overview").toString())
            listrelease_date.add((JSONObject(json).getJSONArray("results").getJSONObject(count2 - 1)).get("release_date").toString())
            listUrlsOfImage.add((JSONObject(json).getJSONArray("results").getJSONObject(count2 - 1)).get("poster_path").toString())
            listTitles.add((JSONObject(json).getJSONArray("results").getJSONObject(count2 - 1)).get("title").toString())
        }

        countFilms = count
    }


}