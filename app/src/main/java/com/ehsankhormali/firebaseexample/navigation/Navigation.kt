package com.ehsankhormali.firebaseexample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ehsankhormali.firebaseexample.screens.home.Home
import com.ehsankhormali.firebaseexample.screens.login.Login
import com.ehsankhormali.firebaseexample.screens.profile.Profile
import com.ehsankhormali.firebaseexample.screens.register.Register

@Composable
fun Navigation(navController:NavHostController,startingScreen:String){

    NavHost(navController = navController, startDestination = startingScreen){

        composable(Screens.Home.name){
            Home(navController = navController)
        }

        composable(Screens.Login.name){
            Login(navController = navController)
        }

        composable(Screens.Register.name){
            Register(navController = navController)
        }

        composable(Screens.Profile.name){
            Profile(navController = navController)
        }
    }

}