package com.portfolio.chatloid.View.Buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.portfolio.chatloid.R

@Composable
fun NotificationButton() {
    Button(
        onClick = {
            print("Test")
        },
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            modifier = Modifier.size(28.dp),
            contentDescription = "Tombol Notifikasi",
            tint = colorResource(R.color.white)
        )
    }
}