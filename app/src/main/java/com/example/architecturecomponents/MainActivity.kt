package com.example.architecturecomponents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.architecturecomponents.Livedataexample.LivedataActivity
import com.example.architecturecomponents.dataBindingexample.DataBindingActivity
import com.example.architecturecomponents.databinding.ActivityMainBinding
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.view.MvvmActivity
import com.example.architecturecomponents.listAdater_DiffUtil.DiffUtilExampleActivity
import com.example.architecturecomponents.room_db.RoomActivity
import com.example.architecturecomponents.simple_Retrofit_Example.RetrofitBasicsActivity

class MainActivity : AppCompatActivity() {
//    val LiveDataExample : Button
//    get() = findViewById(R.id.LivedataExamplebtn)
//    val DataBindingexample : Button
//    get() = findViewById(R.id.dataBindingbtn1)

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.LivedataExamplebtn.setOnClickListener {
            val intent = Intent(this, LivedataActivity::class.java)
            startActivity(intent)
        }
        binding.dataBindingbtn1.setOnClickListener {
            val intent = Intent(this, DataBindingActivity::class.java)
            startActivity(intent)
        }
        binding.roomDbBtn.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }
        binding.listadapterBtn.setOnClickListener {
            val intent = Intent(this, DiffUtilExampleActivity::class.java)
            startActivity(intent)
        }
        binding.basicsOfRetrofitBtn.setOnClickListener {
            val intent = Intent(this, RetrofitBasicsActivity::class.java)
            startActivity(intent)
        }
        binding.MVVMRetrofitBtn.setOnClickListener {
            val intent = Intent(this, MvvmActivity::class.java)
            startActivity(intent)
        }
    }
}