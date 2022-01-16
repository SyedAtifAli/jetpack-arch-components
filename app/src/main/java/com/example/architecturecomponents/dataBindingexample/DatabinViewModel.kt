package com.example.architecturecomponents.dataBindingexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DatabinViewModel : ViewModel() {

    val quotesLiveData = MutableLiveData("livedata ka maal")
}