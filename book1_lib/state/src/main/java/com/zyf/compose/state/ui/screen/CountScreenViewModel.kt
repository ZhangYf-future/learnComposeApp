package com.zyf.compose.state.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CountScreenViewModel: ViewModel() {

    var countState = MutableStateFlow(0)
    fun increment(){
        viewModelScope.launch {
            countState.emit(countState.value + 1)
        }

    }

    fun decrement(){
        viewModelScope.launch {
            countState.emit(countState.value - 1)
        }
    }

}