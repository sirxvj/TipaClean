package com.example.tipaclean.data.remote.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tipaclean.domain.model.PrepodSaved


data class Prepod(
   val academicDepartment: List<String>,
    val calendarId: String,
    val degree: String,
    val fio: String,
    val firstName: String,
   val id: Int,
   val lastName: String,
   val middleName: String,
    val photoLink: String,
   val rank: String,
  val urlId: String
)

fun Prepod.toPrepodSaved(): PrepodSaved {

    return PrepodSaved(
        academicDepartment = academicDepartment?.toString()?:"None",
        calendarId = calendarId,
        degree = degree,
        fio = fio,
        firstName = firstName,
        id = id,
        lastName = lastName,
        middleName = middleName,
        photoLink = photoLink,
        rank = rank ?: "",
        urlId = urlId
    )
}
