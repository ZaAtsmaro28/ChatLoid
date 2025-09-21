package com.portfolio.chatloid.view.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.R
import com.portfolio.chatloid.view.Buttons.BasicIconButton
import com.portfolio.chatloid.dummyData.notifList
import com.portfolio.chatloid.navigation.LocalNavController

@Composable
fun NotificationScreen() {
    Scaffold(
        topBar = { HeaderNotif() }
    ) { innerPadding: PaddingValues ->
        Column(
            modifier = Modifier
                .background(colorResource(R.color.white))
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NotifList(notifList)
        }
    }
}


@Composable
fun HeaderNotif(modifier: Modifier = Modifier) {
    val navController = LocalNavController.current
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(70.dp)
            .fillMaxWidth()
            .background(colorResource(R.color.gray))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicIconButton(
                icon = Icons.Outlined.ArrowBack,
                desc = "Tombol Logout",
                modifier = modifier.size(30.dp)
            ){
                navController.navigate("main_screen")
            }
            Text(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                text = "Notifikasi",
                color = colorResource(R.color.primary)
            )
        }
        Divider(
            color = colorResource(R.color.primary),
            thickness = 2.dp,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}