package com.portfolio.chatloid.view.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.R

@Composable
fun NotifItemList(image: Painter,name: String, desc: String, time: String, isNeedAction: Boolean) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = image,
                contentDescription = "avatar pengguna",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(37.dp)
                    .clip(CircleShape)
                    .border(1.dp, colorResource(R.color.primary), CircleShape)
            )

            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    color = colorResource(id = R.color.black)
                                )
                            ) {
                                append(name)
                            }

                            append(" ")

                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    color = colorResource(id = R.color.black)
                                )
                            ) {
                                append(desc)
                            }
                        },
                        maxLines = 2,
                        modifier = Modifier.weight(7f)
                    )
                    Text(
                        text = time,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = colorResource(R.color.black),
                        modifier = Modifier.weight(1f)
                    )
                }
                if (isNeedAction) {
                    NotificationActionButton()
                } else {
                    Spacer(modifier = Modifier.height(0.dp))
                }


            }
        }
        Spacer(Modifier.height(8.dp))
        Box(Modifier
            .height(1.dp)
            .background(colorResource(R.color.gray))
            .fillMaxWidth())
        Spacer(Modifier.height(12.dp))
    }

}


@Composable
fun NotificationActionButton(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Button(
            onClick = {

            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.black)
            ),
            modifier = Modifier
                .border(
                    2.dp,
                    colorResource(R.color.black),
                    RoundedCornerShape(8.dp)
                )
                .height(36.dp)
        ) {
            Text(
                text = "Terima",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(R.color.black)
            )
        }

        Spacer(Modifier.width(8.dp))

        Button(
            onClick = {

            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.black)
            ),
            modifier = Modifier
                .border(
                    2.dp,
                    colorResource(R.color.black),
                    RoundedCornerShape(8.dp)
                )
                .height(36.dp),
        ) {
            Text(
                text = "Tolak",
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(R.color.black)
            )
        }
    }
}