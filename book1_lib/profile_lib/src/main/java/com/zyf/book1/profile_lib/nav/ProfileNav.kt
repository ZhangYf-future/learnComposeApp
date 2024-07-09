package com.zyf.book1.profile_lib.nav

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.zyf.book1.profile_lib.ui.ProfileHomeScreen
import com.zyf.book1.profile_lib.ui.UserDetailsScreen
import com.zyf.book1.profile_lib.ui.UserInfoScreen

fun NavGraphBuilder.profileNav(controller: NavController){
    navigation(startDestination = "profileHome", route = "profile"){
        composable("profileHome"){
            ProfileHomeScreen {
                controller.navigate("userInfo")
            }
        }

        composable("userInfo/{id}?userName={userName}", arguments = listOf(
            navArgument("id"){
                type = NavType.IntType
                defaultValue = 0
            },
            navArgument("userName"){
                type = NavType.StringType
                defaultValue = "unknow"
                nullable = true
            }
        ), deepLinks = listOf(
            navDeepLink {
                uriPattern = "zyf_app://learn_compose_app/profile/{id}?userName={userName}"
            }
        )){
            val id = it.arguments?.getInt("id")
            val userName = it.arguments?.getString("userName")
            Log.i("UserProfileNav","id: $id, userName: $userName")
            UserInfoScreen {
                controller.navigate("profileHome"){
                    popUpTo("profileHome"){
                        inclusive = true
                    }
                }
            }
        }

        composable("userDetails",deepLinks = listOf(
            navDeepLink {
                uriPattern = "android-app://learn-compose-app/userDetails"
            }
        )){
            UserDetailsScreen()
        }
    }
}