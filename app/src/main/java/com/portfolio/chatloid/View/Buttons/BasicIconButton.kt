package com.portfolio.chatloid.view.Buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.portfolio.chatloid.R

@Composable
fun BasicIconButton(icon: ImageVector, modifier: Modifier, desc: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.width(50.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(colorResource(R.color.gray)),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            modifier = modifier,
            imageVector = icon,
            contentDescription = desc,
            tint = colorResource(R.color.white)
        )
    }
}