package com.example.architecturecomponents.dataBindingexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.architecturecomponents.R
import com.example.architecturecomponents.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    lateinit var binding: ActivityDataBindingBinding
    lateinit var viewModel: DatabinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        val quoteobj = Quote("blah blah blah",
            "atif"
                    ,"https://developer.android.com/topic/libraries/architecture/images/final-architecture.png")
        binding.quotebind = quoteobj

        //binding variable with view model to directly get data from livedata
        viewModel = ViewModelProvider(this).get(DatabinViewModel::class.java)
        binding.model = viewModel

    }
}