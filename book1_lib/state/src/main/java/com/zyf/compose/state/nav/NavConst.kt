package com.zyf.compose.state.nav

sealed class NavConst(val name: String) {
    data object HomeScreen: NavConst(ROUTE_NAME_MODULE_HOME_STATE)
    data object CountScreen: NavConst("CountScreen")
    data object SideEffectDemoScreen: NavConst("SideEffectDemoScreen")
    data object LaunchedEffectDemoScreen: NavConst("LaunchedEffectDemoScreen")
}