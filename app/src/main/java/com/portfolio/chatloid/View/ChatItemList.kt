package com.portfolio.chatloid.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.R

@Composable
fun ChatItemList(image: Painter,name: String, previewChat: String, time: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 0.dp, 0.dp, 8.dp)
//        .background(Color.Blue)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(1.dp, colorResource(R.color.primary),CircleShape)
        ) {
            Image(
                painter = image,
                contentDescription = "avatar pengguna",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(60.dp)
            )
        }
        Spacer(Modifier.width(10.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    color = colorResource(R.color.black),
                    modifier = Modifier.weight(7f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = time,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.SansSerif,
                    color = colorResource(R.color.black),
                    modifier = Modifier.weight(1f)
                )
            }
            Text(
                text = previewChat,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(R.color.black),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}