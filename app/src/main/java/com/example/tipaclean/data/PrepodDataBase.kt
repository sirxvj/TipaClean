package com.example.tipaclean.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tipaclean.domain.model.PrepodSaved

@Database(entities = [PrepodSaved::class], version = 1)
abstract class PrepodDataBase:RoomDatabase() {
    abstract fun prepodDao():PrepodDao
}