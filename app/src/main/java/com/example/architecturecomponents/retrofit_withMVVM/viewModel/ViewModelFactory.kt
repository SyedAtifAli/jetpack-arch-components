package com.example.architecturecomponents.retrofit_withMVVM.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecturecomponents.retrofit_withMVVM.repo.QuoteRepository

class ViewModelFactory(private val repository: QuoteRepository, private val page : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MvvmViewModel(repository,page) as T
    }
}