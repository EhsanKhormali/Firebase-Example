package com.ehsankhormali.firebaseexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.ehsankhormali.firebaseexample.navigation.Navigation
import com.ehsankhormali.firebaseexample.navigation.Screens
import com.ehsankhormali.firebaseexample.ui.theme.TomerKarabukTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TomerKarabukTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val firebaseUser = FirebaseAuth.getInstance().currentUser
                    val startingScreen =
                        if (firebaseUser == null){
                            Screens.Login.name
                        }else{
                            Screens.Home.name
                        }
                    Scaffold (
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "Firebase Example") },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        //Toast.makeText(contextForToast, "Nav Icon Click", Toast.LENGTH_SHORT).show()
                                    }) {
                                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                                    }
                                },
                                actions = {
                                    IconButton(onClick = {
                                        //Toast.makeText(contextForToast, "Add Click", Toast.LENGTH_SHORT).show()
                                    }) {
                                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add Items")
                                    }
                                }
                            )
                        },
                        bottomBar = {
                            val bottomNavigation = listOf(Screens.Home, Screens.Profile)
                            NavigationBar {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentDestination = navBackStackEntry?.destination
                                bottomNavigation.forEach { screen ->
                                    NavigationBarItem(
                                        selected = currentDestination?.hierarchy?.any { it.route == screen.name } == true,
                                        onClick = {
                                            navController.navigate(screen.name) {
                                                // Pop up to the start destination of the graph to
                                                // avoid building up a large stack of destinations
                                                // on the back stack as users select items
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                // Avoid multiple copies of the same destination when
                                                // reselecting the same item
                                                launchSingleTop = true
                                                // Restore state when reselecting a previously selected item
                                                restoreState = true
                                            }
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = when (screen) {
                                                    Screens.Home -> {
                                                        Icons.Default.Home
                                                    }

                                                    Screens.Profile -> {
                                                        Icons.Default.AccountCircle
                                                    }

                                                    else -> {
                                                        Icons.Default.Error
                                                    }
                                                },
                                                contentDescription = "home navigation"
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    ){
                        Surface(modifier = Modifier.padding(it)) {
                            Navigation(navController =navController,startingScreen=startingScreen)
                        }
                    }


                }
            }
        }
    }
}