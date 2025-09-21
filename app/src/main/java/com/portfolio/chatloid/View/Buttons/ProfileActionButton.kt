package com.portfolio.chatloid.view.Buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.R

@Composable
fun ProfileActionButton(modifier: Modifier = Modifier){
    var onEditMode by remember {
        mutableStateOf(false)
    }
    var button_text = ""
    Box {
        Button(
            modifier = modifier.width(97.dp),
            onClick = {
                onEditMode = !onEditMode
            },
            border = BorderStroke(1.dp, colorResource(R.color.primary)),
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
            if (onEditMode) button_text = "Simpan"
            else button_text = "Edit"
            Text(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                text = button_text,
                color = colorResource(R.color.white)
            )
        }
    }
}