package com.example.tipaclean.data.repository
import com.example.tipaclean.data.Retrofitinstance
import com.example.tipaclean.data.remote.ApiService
import com.example.tipaclean.data.remote.dto.toPrepodSaved

import com.example.tipaclean.domain.model.PrepodSaved
import com.example.tipaclean.domain.repository.Repository
import javax.inject.Inject
class RepositoryIMPL:Repository {
    override suspend fun getPrepods(): List<PrepodSaved> {
        val ml : MutableList<PrepodSaved> = mutableListOf();
        for(a in Retrofitinstance.api.getPrepods()){
            ml.add(a.toPrepodSaved())
        }
        return ml.toList()
    }
}