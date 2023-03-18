package com.example.tipaclean.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tipaclean.domain.model.PrepodSaved

@Dao
interface PrepodDao {
    @Query("SELECT * FROM PrepodSaved")
    fun getAll(): List<PrepodSaved>

    @Insert
    fun insertAll(vararg prepods: PrepodSaved)
}