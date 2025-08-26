package com.portfolio.chatloid.View.Buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.portfolio.chatloid.R

@Composable
fun AddContactFloatingButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp, 25.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        ElevatedButton(
            onClick = {
                print("test")
            },
            modifier = Modifier.size(55.dp),
            contentPadding = PaddingValues(0.dp),
            shape = CircleShape,
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = colorResource(R.color.primary),
                contentColor = colorResource(R.color.black)
            )
        ) {
            Icon(
                imageVector = Icons.Filled.PersonAdd,
                contentDescription = "Tombol tambah kontak",
                modifier = modifier
                    .size(38.dp),
                tint = colorResource(R.color.black)
            )
        }
    }
}