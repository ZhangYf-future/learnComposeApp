package com.zyf.compose.state.vm

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LaunchedEffectViewMode: ViewModel() {

    private val mutableErrorFlow:MutableStateFlow<Boolean> = MutableStateFlow(false)
    val errorFlow: StateFlow<Boolean> = mutableErrorFlow


    fun changeState(){
        viewModelScope.launch {
            val currentState = mutableErrorFlow.value
            mutableErrorFlow.emit(!currentState)
        }
    }

}