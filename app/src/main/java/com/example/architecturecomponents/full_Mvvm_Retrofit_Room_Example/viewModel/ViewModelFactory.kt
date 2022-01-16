package com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.repo.QuoteRepository

class ViewModelFactory(private val repository: QuoteRepository, private val page : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MvvmViewModel(repository,page) as T
    }
}