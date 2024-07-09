package com.zyf.book1.login_lib.nav

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zyf.book1.login_lib.ui.screen.ForgetPasswordScreen
import com.zyf.book1.login_lib.ui.screen.LoginHomeScreen
import com.zyf.book1.login_lib.ui.viewmodel.LoginScreenViewModel

fun NavGraphBuilder.loginNav(controller: NavController) {
    navigation(startDestination = "loginHome", route = "login") {
        composable(route = "loginHome") {
            val viewModel =
                viewModel<LoginScreenViewModel>(factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return LoginScreenViewModel() as T
                    }
                })
            LoginHomeScreen(viewModel, {
                controller.navigate("loginForgetPassword")
            }, {
                controller.navigate("userInfo/321")
            }, {
                controller.navigate(Uri.parse("zyf_app://learn_compose_app/profile/123456?userName=John"))
            }
            )
        }
        composable(route = "loginForgetPassword") {
            ForgetPasswordScreen {
                controller.navigate("loginHome") {
                    popUpTo("loginHome") {
                        inclusive = true
                    }
                }
            }
        }
    }
}