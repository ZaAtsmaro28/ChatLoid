package com.portfolio.chatloid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.portfolio.chatloid.navigation.AppNavigation
import com.portfolio.chatloid.ui.theme.ChatLoidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatLoidTheme {
                Column(modifier = Modifier
                    .fillMaxSize()
                ) {
                    AppNavigation()
                }
            }
        }
    }
}