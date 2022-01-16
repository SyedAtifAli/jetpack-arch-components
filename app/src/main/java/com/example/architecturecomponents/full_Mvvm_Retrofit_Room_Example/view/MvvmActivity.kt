package com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturecomponents.R
import com.example.architecturecomponents.databinding.MvvmActivtyBinding
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.Adapters.RvAdapter
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.api.QuoteApi
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.api.Retrofithelper
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.roomdb.Quotedatabase
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.repo.QuoteRepository
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.viewModel.MvvmViewModel
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.viewModel.ViewModelFactory

class MvvmActivity : AppCompatActivity() {

    lateinit var binding : MvvmActivtyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.mvvm_activty)

        val api = Retrofithelper.getInstance().create(QuoteApi::class.java)
        val database = Quotedatabase.getDBInstance(this)
        val repo = QuoteRepository(api,database)
        val viewmodel =
            ViewModelProvider(this, ViewModelFactory(repo, (1..10).random()))
                .get(MvvmViewModel::class.java)

        binding.recyclerView3.layoutManager = LinearLayoutManager(this)


        viewmodel.quote.observe(this, Observer {
            var adapter = RvAdapter(it)
            binding.recyclerView3.adapter = adapter
            binding.progressBar3.visibility = View.GONE
        })


    }
}