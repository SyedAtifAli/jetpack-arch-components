package com.example.architecturecomponents.room_db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity(tableName = "contactsTable")
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name:String,
    val number: Int,
    val date: Date
    )