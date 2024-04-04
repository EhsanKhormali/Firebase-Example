package com.ehsankhormali.firebaseexample.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {

    Surface {
        Column {
            Text(text = "hello world" + FirebaseAuth.getInstance().currentUser?.email)
        }
    }


}