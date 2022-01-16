package com.example.architecturecomponents.retrofit_withMVVM

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturecomponents.R
import com.example.architecturecomponents.databinding.ActivityRetrofitMvvmBinding
import com.example.architecturecomponents.retrofit_withMVVM.Adapters.Adapter
import com.example.architecturecomponents.retrofit_withMVVM.model.QuoteApi
import com.example.architecturecomponents.retrofit_withMVVM.model.Retrofithelper
import com.example.architecturecomponents.retrofit_withMVVM.repo.QuoteRepository
import com.example.architecturecomponents.retrofit_withMVVM.viewModel.MvvmViewModel
import com.example.architecturecomponents.retrofit_withMVVM.viewModel.ViewModelFactory

class RetrofitMvvmActivity : AppCompatActivity() {

    lateinit var binding: ActivityRetrofitMvvmBinding
    lateinit var Adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit_mvvm)

        val api = Retrofithelper.getInstance().create(QuoteApi::class.java)
        val repo = QuoteRepository(api)
        val viewmodel =
            ViewModelProvider(this, ViewModelFactory(repo, (1..10).random()))
                .get(MvvmViewModel::class.java)

        binding.recyclerView2.layoutManager = LinearLayoutManager(this)

        viewmodel.quotes.observe(this, Observer {
            Adapter = Adapter(it)
            binding.recyclerView2.adapter = Adapter
            binding.progressBar2.visibility = View.GONE
        })


    }
}