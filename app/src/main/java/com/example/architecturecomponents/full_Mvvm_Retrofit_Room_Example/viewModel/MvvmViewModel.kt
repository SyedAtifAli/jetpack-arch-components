package com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.api.Result
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.repo.QuoteRepository
import kotlinx.coroutines.launch

class MvvmViewModel(
    private val repository: QuoteRepository,
    private val page: Int
) : ViewModel() {

    val quote: LiveData<List<Result>>
        get() = repository.quotes

    init {
        viewModelScope.launch {
            repository.getQuote(page)
        }
    }


}