package com.example.PerfectMovie

interface ApiInterface {

    var list_vote_average : MutableList<String>
    var listrelease_date : MutableList<String>
    var listoverview : MutableList<String>
    var listUrlsOfImage : MutableList<String>
    var listTitles : MutableList<String>

    var countFilms : Int
    var jsonurl : String

    fun getCount() : Int

    fun getTitle(index : Int) : String
    fun getvote_average(index : Int) : String
    fun getUrlToImage(index : Int) : String
    fun getOverview(index : Int) : String
    fun getRealeaseDate(index : Int) : String

    fun clearList()
    fun getInfo()


}