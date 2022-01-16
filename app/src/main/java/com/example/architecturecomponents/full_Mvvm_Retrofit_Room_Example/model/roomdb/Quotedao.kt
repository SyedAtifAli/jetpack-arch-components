package com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.api.Result

@Dao
interface Quotedao {

    @Insert
    suspend fun insert(quoteEntity: List<Result>)

    @Query("select * from quoteTable")
    suspend fun getQuotesfromRoom(): List<Result>
}