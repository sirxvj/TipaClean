package com.example.tipaclean.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PrepodSaved(

    val academicDepartment: String,
    val calendarId: String,
    val degree: String,
    val fio: String,
    val firstName: String,
    val id: Int,
    val lastName: String,
    val middleName: String,
    val photoLink: String,
    val rank: String,
    @PrimaryKey val urlId: String

)
