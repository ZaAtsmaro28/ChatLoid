package com.portfolio.chatloid.View.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.portfolio.chatloid.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.login_circle),
            contentDescription = "Ilustrasi Dekorasi",
            modifier = modifier
                .offset(x = (-15).dp, y = (-88).dp)
                .align(Alignment.TopStart)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Column(
                modifier
//                    .background(Color.Red)
                    .fillMaxWidth()
                    .weight(4f),
                Arrangement.Center,
                Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.login_decoration),
                    contentDescription = "Ilustrasi Dekorasi",
                    modifier = modifier
                        .size(269.dp, 225.dp)
//                    .offset(y = (-170).dp)
//                    .align(Alignment.Center)
                )

            }
            Column(
                modifier
//                    .background(Color.Green)
                    .fillMaxWidth()
                    .weight(1f),
                Arrangement.SpaceBetween,
                Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.login_icon_1),
                    contentDescription = "Ilustrasi Dekorasi",
                )
                Image(
                    painter = painterResource(R.drawable.login_icon_2),
                    contentDescription = "Ilustrasi Dekorasi",
                )

            }
            Column(
                modifier
//                    .background(Color.Blue)
                    .fillMaxWidth()
                    .weight(5f),
                Arrangement.SpaceAround,
                Alignment.CenterHorizontally) {
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = colorResource(R.color.primary),
                        contentColor = colorResource(R.color.black)
                    )
                ) {
                    Text("Button Login")
                }
                Image(
                    painter = painterResource(R.drawable.login_icon_3),
                    contentDescription = "Ilustrasi Dekorasi",
                )
            }




        }
    }
}