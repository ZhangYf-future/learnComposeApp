package com.zyf.book1.uicomponent.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zyf.book1.uicomponent.ui.HomeScreen
import com.zyf.book1.uicomponent.ui.ModifierBackgroundScreen
import com.zyf.book1.uicomponent.ui.ModifierBorderPaddingScreen
import com.zyf.book1.uicomponent.ui.ModifierFillMaxScreen
import com.zyf.book1.uicomponent.ui.ModifierSizeScreen

//当前模块root nav route
const val UI_COMPONENT_ROOT_NAV_ROUTE = "uiComponentRootRoute"
//首页
internal const val NAV_ROUTE_HOME = "uiComponentHomeScreen"
//Modifier.size页面
internal const val NAV_ROUTE_MODIFIER_SIZE = "uiComponentModifierSizeScreen"
//Modifier.background页面
internal const val NAV_ROUTE_MODIFIER_BACKGROUND = "uiComponentModifierBackgroundScreen"
//Modifier.fillMax相关页面
internal const val NAV_ROUTE_MODIFIER_FILL_MAX = "uiComponentModifierFillMaxScreen"
//Modifier.border&padding页面
internal const val NAV_ROUTE_MODIFIER_BORDER_PADDING = "uiComponentModifierBorderPadding"


fun NavGraphBuilder.uiComponentNav(navController: NavController){
    navigation(route = UI_COMPONENT_ROOT_NAV_ROUTE, startDestination = NAV_ROUTE_HOME){
        composable(route = NAV_ROUTE_HOME){
            HomeScreen{
                navController.navigate(it)
            }
        }

        composable(route = NAV_ROUTE_MODIFIER_SIZE){
            ModifierSizeScreen()
        }

        composable(route = NAV_ROUTE_MODIFIER_BACKGROUND){
            ModifierBackgroundScreen()
        }

        composable(route = NAV_ROUTE_MODIFIER_FILL_MAX){
            ModifierFillMaxScreen()
        }

        composable(route = NAV_ROUTE_MODIFIER_BORDER_PADDING){
            ModifierBorderPaddingScreen()
        }
    }
}