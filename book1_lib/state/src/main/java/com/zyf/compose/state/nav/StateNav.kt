package com.zyf.compose.state.nav


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zyf.compose.state.ui.screen.CountScreenViewModel
import com.zyf.compose.state.ui.screen.CounterScreen
import com.zyf.compose.state.ui.screen.HomeScreen
import com.zyf.compose.state.ui.screen.LaunchedEffectDemoScreen
import com.zyf.compose.state.ui.screen.SlideEffectDemoScreen
import com.zyf.compose.state.vm.LaunchedEffectViewMode

const val ROUTE_NAME_MODULE_HOME_STATE = "stateHome"


fun NavGraphBuilder.stateNav(controller: NavController){
    navigation(NavConst.HomeScreen.name,"stateHomeRoute"){
        composable(NavConst.HomeScreen.name){
            HomeScreen {navConst ->
                controller.navigate(navConst.name)
            }
        }
        composable(NavConst.CountScreen.name){
            val viewModel = viewModel(
                modelClass = CountScreenViewModel::class.java,
                factory = object : ViewModelProvider.NewInstanceFactory() {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return CountScreenViewModel() as T
                    }
                })
            CounterScreen(viewModel){
                controller.popBackStack()
            }
        }

        composable(NavConst.SideEffectDemoScreen.name){
            SlideEffectDemoScreen()
        }

        composable(NavConst.LaunchedEffectDemoScreen.name){
            val viewModel = viewModel(modelClass = LaunchedEffectViewMode::class.java)
            LaunchedEffectDemoScreen(viewModel = viewModel)
        }
    }
}