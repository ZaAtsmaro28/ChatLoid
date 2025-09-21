package com.portfolio.chatloid.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Divider
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
import com.portfolio.chatloid.navigation.LocalNavController

@Composable
fun HeaderApp(title: String, modifier: Modifier = Modifier) {
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
                .padding(16.dp, 0.dp, 10.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                text = title,
                color = colorResource(R.color.primary)
            )
            Row {
                BasicIconButton(
                    icon = Icons.Outlined.Notifications,
                    desc = "Tombol Notifikasi",
                    modifier = modifier.size(30.dp)
                ){
                    navController.navigate("notification_screen")
                }
                Spacer(Modifier.size(4.dp))
                BasicIconButton(
                    icon = Icons.Outlined.Logout,
                    desc = "Tombol Logout",
                    modifier = modifier.size(30.dp)
                ){
                    navController.navigate("login")
                }
            }
        }
        Divider(
            color = colorResource(R.color.primary),
            thickness = 2.dp,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}