package com.example.quoteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quoteapp.model.quote
import com.google.gson.Gson

object Datamanager {

    var data = emptyArray<quote>()
    var currentQuote:quote?=null

    var currentPage = mutableStateOf(Pages.LISTING)
    var IsDataLoaded= mutableStateOf(false)

    fun loadAsset(context: Context){
        val inputStream=context.assets.open("quote.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json= String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data=gson.fromJson(json,Array<quote>::class.java)
        IsDataLoaded.value=true
    }

    fun switchPages(quote: quote?){
        if(currentPage.value==Pages.LISTING){
            currentQuote=quote
            currentPage.value = Pages.DETAIL
        }
        else{
            currentPage.value= Pages.LISTING
        }
    }
}


