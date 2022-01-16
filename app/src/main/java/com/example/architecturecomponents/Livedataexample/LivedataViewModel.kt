package com.example.architecturecomponents.Livedataexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LivedataViewModel : ViewModel() {
    fun updatefact() {
        FactsLivedata.value = "this is another fact"
    }

    val FactsLivedata = MutableLiveData<String>("this is a fact")


}