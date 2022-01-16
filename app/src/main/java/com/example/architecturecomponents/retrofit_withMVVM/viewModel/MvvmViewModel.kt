package com.example.architecturecomponents.retrofit_withMVVM.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponents.retrofit_withMVVM.model.QuoteList
import com.example.architecturecomponents.retrofit_withMVVM.repo.QuoteRepository
import kotlinx.coroutines.launch

class MvvmViewModel(private val repository: QuoteRepository, private val page: Int) : ViewModel() {

    init {
        viewModelScope.launch {
            repository.getQuote(page)
        }
    }

    val quotes: LiveData<QuoteList>
    get() = repository.quotes

}