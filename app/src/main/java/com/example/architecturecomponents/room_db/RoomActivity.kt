package com.example.architecturecomponents.room_db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.architecturecomponents.R
import com.example.architecturecomponents.databinding.ActivityRoomBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class RoomActivity : AppCompatActivity() {
    lateinit var binding: ActivityRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_room)

        val database = ContactDatabase.getdatabase(applicationContext)

        //inerting into db using coroutine
        GlobalScope.launch {
            database.contactdao().insert(Contact(0,"ali",1234567890,Date()))
        }
    }
}