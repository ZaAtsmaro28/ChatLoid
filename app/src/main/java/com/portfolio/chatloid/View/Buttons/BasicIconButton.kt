package com.portfolio.chatloid.View.Buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.portfolio.chatloid.R

@Composable
fun BasicIconButton(icon: ImageVector, desc: String) {
    Button(
        modifier = Modifier.width(50.dp),
        onClick = {
            print("Test")
        },
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            modifier = Modifier.size(30.dp),
            imageVector = icon,
            contentDescription = desc,
            tint = colorResource(R.color.white)
        )
    }
}