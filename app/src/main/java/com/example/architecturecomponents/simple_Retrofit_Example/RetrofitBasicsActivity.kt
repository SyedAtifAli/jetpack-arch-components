package com.example.architecturecomponents.simple_Retrofit_Example

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturecomponents.R
import com.example.architecturecomponents.databinding.ActivityRetrofitBasicsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RetrofitBasicsActivity : AppCompatActivity() {


    lateinit var binding: ActivityRetrofitBasicsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit_basics)

        binding.quotelistRv.layoutManager = LinearLayoutManager(this)
        val quoteApi = Retrofithelper.getInstance().create(QuoteApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val result = quoteApi.getQuotes((0..10).random())
            if (result.isSuccessful){
                withContext(Dispatchers.Main){
                    binding.progressBar.visibility = View.GONE
                    val adapter = Adapter(result.body()!!)
                    binding.quotelistRv.adapter = adapter
                }
            }
        }
    }

}