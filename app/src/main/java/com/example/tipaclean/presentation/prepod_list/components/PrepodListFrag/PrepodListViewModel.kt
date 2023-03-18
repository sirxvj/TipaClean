package com.example.tipaclean.presentation.prepod_list.components.PrepodListFrag

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.tipaclean.common.Resourse
import com.example.tipaclean.data.PrepodDataBase
import com.example.tipaclean.data.repository.RepositoryIMPL
import com.example.tipaclean.domain.use_case.get_prepods.GetPrepodsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrepodListViewModel (

): ViewModel(){
    
    private val _state = MutableLiveData<PrepodListState>(PrepodListState())
    private val getPrepodsUseCase by lazy { GetPrepodsUseCase()};
    lateinit var context: Context
    val state: MutableLiveData<PrepodListState> = _state

    init {
        getPrepods()
    }

    private fun getPrepods(){
        getPrepodsUseCase().onEach { result->
            when(result){
                is Resourse.Success->{
                    _state.value = PrepodListState(prepods = result.data?: emptyList())
                }
                is Resourse.Error ->{
                    val db = Room.databaseBuilder(
                         context,
                          PrepodDataBase::class.java, "database"
                    ).allowMainThreadQueries().build()
                     val userDao = db.prepodDao()
                    val prepd = userDao.getAll()
                    _state.value = PrepodListState(prepods = prepd?: emptyList())
                }
                is Resourse.Loading -> {
                    _state.value = PrepodListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}