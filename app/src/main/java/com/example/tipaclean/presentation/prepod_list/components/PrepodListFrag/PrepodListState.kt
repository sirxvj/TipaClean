package com.example.tipaclean.presentation.prepod_list.components.PrepodListFrag


import com.example.tipaclean.domain.model.PrepodSaved

data class PrepodListState(
    val isLoading: Boolean = false,
    var prepods: List<PrepodSaved> = emptyList(),
    val error:String = ""
)
