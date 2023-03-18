package com.example.tipaclean.domain.use_case.get_prepods

import android.content.Context
import androidx.room.Room
import com.example.tipaclean.common.Resourse
import com.example.tipaclean.data.PrepodDataBase
import com.example.tipaclean.data.remote.dto.Prepod
import com.example.tipaclean.data.repository.RepositoryIMPL
import com.example.tipaclean.domain.model.PrepodSaved

import com.example.tipaclean.domain.repository.Repository
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_ApplicationContextModule
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import javax.inject.Inject

class GetPrepodsUseCase()
{
    private val repository = RepositoryIMPL()
    lateinit var context: Context
//    lateinit var context:Context
//    val db = Room.databaseBuilder(
//        context,
//        PrepodDataBase::class.java, "database"
//    ).allowMainThreadQueries().build()
//    val userDao = db.prepodDao()
     operator fun invoke(): Flow<Resourse<List<PrepodSaved>>> = flow{
         try {
            emit(Resourse.Loading())
             val prepods = repository.getPrepods().map { it }
             emit(Resourse.Success(prepods))
         }
         catch (e:HttpException){
            emit(Resourse.Error(e.localizedMessage?:"Zalupa"))
         }
         catch (e:IOException){
            emit(Resourse.Error(e.localizedMessage?:"Cringe no internet conection"))
         }
     }
}