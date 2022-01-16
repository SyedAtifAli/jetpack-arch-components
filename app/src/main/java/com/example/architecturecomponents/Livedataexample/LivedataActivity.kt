package com.example.architecturecomponents.Livedataexample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.architecturecomponents.R

class LivedataActivity : AppCompatActivity() {

    lateinit var livedataViewModel: LivedataViewModel

    val textview: TextView
        get() = findViewById(R.id.textView1)

    val button: Button
        get() = findViewById(R.id.button1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.livedataactivitylayout)

        livedataViewModel = ViewModelProvider(this)[LivedataViewModel::class.java]

        livedataViewModel.FactsLivedata.observe(this, Observer {
            textview.text = it
        })

        button.setOnClickListener {
            livedataViewModel.updatefact()
        }
    }

}
