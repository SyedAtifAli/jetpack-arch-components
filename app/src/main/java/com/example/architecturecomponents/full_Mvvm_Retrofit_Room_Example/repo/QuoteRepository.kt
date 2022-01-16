package com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.api.QuoteApi
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.api.Result
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.roomdb.Quotedatabase
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.util.NetworkUtil.Companion.internetIsConnected

class QuoteRepository(
    private val quoteApi: QuoteApi,
    private val database: Quotedatabase,
) {

    private val quotesLiveData = MutableLiveData<List<Result>>()

    val quotes: LiveData<List<Result>>
        get() = quotesLiveData

    suspend fun getQuote(page: Int) {
        //if internet is connected api call and push the resultant data into room
        if (internetIsConnected()) {
            val result = quoteApi.getQuotes(page)
            if (result.body() != null) {
                database.quotedao().insert(result.body()!!.results)
                Log.d("atif", "insered into db")
                quotesLiveData.postValue(result.body()!!.results)
            }
        }
        else //if internet is not available take data from room
            quotesLiveData.postValue(database.quotedao().getQuotesfromRoom())
    }
}