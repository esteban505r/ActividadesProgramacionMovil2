package com.esteban.lopez.myapplication

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.esteban.lopez.myapplication.ui.theme.LoggedScreen

@Composable
fun NavHostWrapper(
    navController: NavHostController,
) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            HomeScreen(navController)
        }
        composable("login"){
            LoginScreen(
                onLoginClick = { email, password ->
                    if(email=="hugoruano.el@academia.umb.edu.co" && password=="123456") {
                        navController.navigate("logged")
                    }
                    else{
                        Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
        composable("logged"){
            LoggedScreen()
        }
    }
}