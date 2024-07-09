package com.zyf.book1app.ui.nav

import android.content.ContentResolver
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentWithReceiverOf
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zyf.book1.login_lib.nav.loginNav
import com.zyf.book1.profile_lib.nav.profileNav
import com.zyf.book1.uicomponent.nav.UI_COMPONENT_ROOT_NAV_ROUTE
import com.zyf.book1.uicomponent.nav.uiComponentNav
import com.zyf.book1app.ui.screen.DetailsScreen
import com.zyf.book1app.ui.screen.HomeScreen
import com.zyf.book1app.ui.screen.MeScreen
import com.zyf.compose.state.nav.ROUTE_NAME_MODULE_HOME_STATE
import com.zyf.compose.state.nav.stateNav

@Composable
fun AppNavigation(){
    val controller = rememberNavController()
    
    NavHost(navController = controller, startDestination = "home"){
        composable("home"){
            HomeScreen({
                controller.navigate("me")
            },{
                controller.navigate("home"){
                    launchSingleTop = true
                }
            },{
                val userName = "Davy"
                val password: String? = null
                controller.navigate("details/1234?isFromHome=${false}&userName=${userName}&password=${password}")
            },{
                controller.navigate("login")
            },{
                controller.navigate("profile")
            },{
                controller.navigate(UI_COMPONENT_ROOT_NAV_ROUTE)
            },{
                controller.navigate(ROUTE_NAME_MODULE_HOME_STATE)
            })
        }
        composable("me"){
            MeScreen{
                controller.navigate("home"){
                    popUpTo("home"){
                      inclusive = true
                    }
                }
            }
        }

        composable("details/{id}?isFromHome={isFromHome}&userName={userName}&password={password}", arguments = listOf(
            navArgument("id"){
                this.type = NavType.IntType
            },
            navArgument("isFromHome"){
                type = NavType.BoolType
                defaultValue = true
            },
            navArgument("userName"){
                type = NavType.StringType
                defaultValue = "John"
            },
            navArgument("password"){
                type = NavType.StringType
                defaultValue = "1123"
                nullable = true
            }
        )){
            val id = it.arguments?.getInt("id")
            val isFromHome = it.arguments?.getBoolean("isFromHome")
            val userName = it.arguments?.getString("userName")
            val password = it.arguments?.getString("password")
            Log.i("NavigateDetails","id is: $id, $isFromHome, $userName, $password")
            DetailsScreen()
        }
        loginNav(controller)
        profileNav(controller)
        uiComponentNav(controller)
        stateNav(controller)
    }
}