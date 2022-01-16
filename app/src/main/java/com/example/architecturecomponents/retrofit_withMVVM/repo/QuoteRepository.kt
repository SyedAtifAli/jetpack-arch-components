package com.example.architecturecomponents.retrofit_withMVVM.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.architecturecomponents.retrofit_withMVVM.model.QuoteApi
import com.example.architecturecomponents.retrofit_withMVVM.model.QuoteList

class QuoteRepository(private val quoteApi: QuoteApi) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuote(page: Int){
        val result = quoteApi.getQuotes(page)
        if (result.body() != null){
            quotesLiveData.postValue(result.body())
        }
    }
}