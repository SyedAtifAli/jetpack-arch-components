package com.example.architecturecomponents.room_db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Contactdao {

    @Insert
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * FROM contactsTable")
    fun getContact(): LiveData<List<Contact>>

}