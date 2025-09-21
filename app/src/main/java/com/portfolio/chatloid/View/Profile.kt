package com.portfolio.chatloid.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.R
import com.portfolio.chatloid.view.Buttons.ProfileActionButton

@Composable
fun ProfilePage(modifier: Modifier = Modifier){
    Column (
        modifier = modifier
            .fillMaxSize()) {
        Box(

            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.gray),
                    shape = RoundedCornerShape(0.dp, 0.dp, 24.dp, 24.dp)
                )
                .weight(1f)

        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(16.dp, 10.dp)
                    .fillMaxWidth()
            ){
                Box(contentAlignment = Alignment.CenterEnd,
                    modifier = modifier
                    .fillMaxWidth()
                ) {
                    ProfileActionButton()
                }
                ProfilePhoto()
                ProfileData()
            }
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(colorResource(R.color.white))
                .weight(1f)
        ){
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = modifier
                    .fillMaxSize()
                    .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Image(
                        painter = painterResource(R.drawable.app_logo),
                        contentDescription = "Logo Aplikasi",
                        modifier = modifier
                            .width(165.dp)
                            .height(28.dp)
                    )
                }
                Image(
                    painter = painterResource(R.drawable.desktop_character),
                    contentDescription = "Ilustrasi Dekorasi",
                    modifier = modifier
                        .width(283.dp)
                        .height(168.dp)
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
private fun ProfilePhoto(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .size(120.dp)
            .clip(CircleShape)
            .border(1.dp, colorResource(R.color.primary),CircleShape)
    ) {
        Image(
            painter = painterResource(R.drawable.pp),
            contentDescription = "foto profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun ProfileData(modifier: Modifier = Modifier){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier.height(14.dp))
        Text(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            text = "Iqmal Akbar Kurnia",
            color = colorResource(R.color.white)
        )
        Spacer(modifier.height(6.dp))
        Text(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            text = "iakbarkurnia@gmail.com",
            color = colorResource(R.color.light_gray)
        )
        Spacer(modifier.height(9.dp))
        Text(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            text = "@Akur01",
            color = colorResource(R.color.primary)
        )
    }
}