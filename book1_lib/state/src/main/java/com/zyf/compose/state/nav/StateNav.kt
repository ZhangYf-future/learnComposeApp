package com.zyf.compose.state.nav


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zyf.compose.state.ui.screen.CounterScreen


const val ROUTE_NAME_MODULE_HOME_STATE = "stateHome"


fun NavGraphBuilder.stateNav(controller: NavController){
    navigation("stateHome","CounterScreen"){
        composable("stateHome"){
            CounterScreen()
        }
    }
}