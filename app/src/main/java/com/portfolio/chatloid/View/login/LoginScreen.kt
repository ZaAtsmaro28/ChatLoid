package com.portfolio.chatloid.view.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.R
import com.portfolio.chatloid.navigation.LocalNavController

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val navController = LocalNavController.current

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
                    .fillMaxWidth()
                    .weight(5f),
                Arrangement.SpaceAround,
                Alignment.CenterHorizontally) {
                Button(
                    onClick = {
                        navController.navigate("main_screen")
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = colorResource(R.color.black)
                    ),
                    modifier = modifier
                        .border(
                        2.dp,
                        colorResource(R.color.black),
                        RoundedCornerShape(12.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(R.drawable.google_icon),
                        contentDescription = null,
                        modifier = modifier.size(26.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Masuk menggunakan akun Google")
                }
                Text(
                    text = "ChatLoid.com",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(R.color.black)
                    )
            }




        }
    }
}