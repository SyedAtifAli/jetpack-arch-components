package com.example.architecturecomponents.room_db

import androidx.room.TypeConverter
import java.util.*


class Convertors {

    @TypeConverter
    fun DatetoLong( value: Date) :Long{
        return value.time
    }
    @TypeConverter
    fun LongtoDate( value: Long) :Date{
        return Date(value)
    }
}