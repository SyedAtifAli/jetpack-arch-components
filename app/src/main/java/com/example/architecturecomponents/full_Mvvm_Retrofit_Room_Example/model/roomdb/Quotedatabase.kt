package com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.api.Result

@Database(entities = [Result::class], version = 1)
abstract class Quotedatabase : RoomDatabase() {

    abstract fun quotedao(): Quotedao

    companion object {
        @Volatile
        private var INSTANCE: Quotedatabase? = null

        fun getDBInstance(context: Context): Quotedatabase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Quotedatabase::class.java,
                        "quotedatabase"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}