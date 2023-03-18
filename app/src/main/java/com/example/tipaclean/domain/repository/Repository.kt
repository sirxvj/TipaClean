package com.example.tipaclean.domain.repository


import com.example.tipaclean.domain.model.PrepodSaved

interface Repository {
    suspend fun getPrepods():List<PrepodSaved>
}