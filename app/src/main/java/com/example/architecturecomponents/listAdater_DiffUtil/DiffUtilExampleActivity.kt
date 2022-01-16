package com.example.architecturecomponents.listAdater_DiffUtil

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturecomponents.R

class DiffUtilExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util_example)

        val recyclerView = findViewById<RecyclerView>(R.id.programmingList)
        val adapter = ProgrammingAdapter()

        val p1 = ProgrammingItem(1,"J","JAVA")
        val p2 = ProgrammingItem(2,"P","PYTHON")
        val p3 = ProgrammingItem(3,"A","ANDROID")

        adapter.submitList(listOf(p1,p2,p3))

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        //handler will add 3 new items in list after 4 seconds
        //diff-util callback will check if any item is same or not
        //if it is same it remains intact
        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val p3 = ProgrammingItem(3,"A","ANDROID")
            val p4 = ProgrammingItem(3,"S","SWIFT")
            val p5 = ProgrammingItem(3,"P","PYTHON")

            adapter.submitList(listOf(p3,p4,p5))
        },4000)
    }
}