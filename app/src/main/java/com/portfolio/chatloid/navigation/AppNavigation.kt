package com.portfolio.chatloid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.portfolio.chatloid.view.BottomNavBar
import com.portfolio.chatloid.view.addContact.AddContactScreen
import com.portfolio.chatloid.view.chatroom.ChatRoom
import com.portfolio.chatloid.view.login.LoginScreen
import com.portfolio.chatloid.view.notification.NotificationScreen


val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("NavController not provided")
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = "login"
        ) {
            composable("login") {
                LoginScreen()
            }
            composable("main_screen") {
                BottomNavBar()
            }
            composable("notification_screen") {
                NotificationScreen()
            }
            composable("addcontact_screen") {
                AddContactScreen()
            }
            composable("chatroom_screen") {
                ChatRoom()
            }
        }
    }

}