package com.portfolio.chatloid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.portfolio.chatloid.View.BottomNavBar
import com.portfolio.chatloid.ui.theme.ChatLoidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatLoidTheme {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)

                ) {
                    BottomNavBar()
                }
            }
        }
    }
}