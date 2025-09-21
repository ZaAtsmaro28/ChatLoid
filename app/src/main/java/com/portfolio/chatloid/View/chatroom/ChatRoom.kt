package com.portfolio.chatloid.view.chatroom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.R
import com.portfolio.chatloid.view.Buttons.BasicIconButton

@Preview
@Composable
fun ChatRoom() {
    Scaffold(
        topBar = { ChatRoomHeader() }
    ) { innerPadding: PaddingValues ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(colorResource(R.color.white))
                .padding(16.dp, 30.dp, 16.dp, 0.dp)
        ) {
            MyBubbleChat("Lorem ipsum dolor sit amet", "19.00")

            FriendBubbleChat("Sed tristique, sapien sit amet convallis malesuada, elit massa cursus neque", "19.00")

            MyBubbleChat("lorem", "19.00")

            FriendBubbleChat("ok", "19.00")

            MyBubbleChat(
                "Nullam vel sapien vitae justo efficitur facilisis. Phasellus commodo magna in magna scelerisque, vitae tincidunt risus porta. Ut luctus, justo ac porta aliquet, erat erat volutpat ipsum, vel accumsan mauris odio sed nulla.",
                "19.00"
            )

            FriendBubbleChat(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tristique, sapien sit amet convallis malesuada, elit massa cursus neque, nec tincidunt nisi lorem at ante. Integer egestas arcu nec lectus faucibus, id gravida nisi vulputate. Nullam vel sapien vitae justo efficitur facilisis.",
                "20.00"
            )
        }
    }
}


@Composable
fun ChatRoomHeader() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .background(colorResource(R.color.primary))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp, 10.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier.width(34.dp),
                onClick = {  },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                    tint = colorResource(R.color.black),
                    modifier = Modifier.size(30.dp)
                )
            }
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.dp, colorResource(R.color.primary), CircleShape)
            ) {
                Image(
                    painter = painterResource(R.drawable.person1),
                    contentDescription = "avatar pengguna",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(50.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    text = "Aldova Ferdiansyah",
                    color = colorResource(R.color.black)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    text = "Online",
                    color = colorResource(R.color.light_gray_text)
                )
            }

        }
        Divider(
            color = colorResource(R.color.black),
            thickness = 2.dp,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun MyBubbleChat(text: String, time: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End)
    {
        Row(
            modifier = Modifier
                .background(
                    colorResource(R.color.primary),
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = 12.dp,
                        bottomEnd = 2.dp
                    )
                )
                .padding(14.dp)
                .widthIn(max = 290.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                textAlign = TextAlign.Justify,
                text = text,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.black),
                modifier = Modifier.widthIn(max = 244.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Dibaca",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.black)
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = time,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.black)
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun FriendBubbleChat(text: String, time: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start)
    {
        Row(
            modifier = Modifier
                .background(
                    colorResource(R.color.gray),
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomStart = 2.dp,
                        bottomEnd = 12.dp
                    )
                )
                .padding(14.dp)
                .widthIn(max = 290.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            Text(
                textAlign = TextAlign.Justify,
                text = text,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.white),
                modifier = Modifier.widthIn(max = 244.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.white)
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = time,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.white)
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}