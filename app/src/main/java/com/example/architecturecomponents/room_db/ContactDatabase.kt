package com.example.architecturecomponents.room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactdao(): Contactdao

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        //migration code
        private val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contactsTable ADD COLUMN date INTEGER NOT NULL DEFAULT(1)")
            }

        }

        fun getdatabase(context: Context): ContactDatabase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contactdb"
                    ).addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!
        }

    }


}