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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.R
import com.portfolio.chatloid.navigation.LocalNavController
import com.portfolio.chatloid.view.Buttons.BasicIconButton

@Preview
@Composable
fun ChatRoom() {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = { ChatRoomHeader() },
        bottomBar = {
            WriteMessageField()
        },
        modifier = Modifier.background(Color.Transparent)
    ) { innerPadding: PaddingValues ->
        Box(
            modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)){
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .background(colorResource(R.color.white))
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Bottom
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                MyBubbleChat("Lorem ipsum dolor sit amet. Sed tristique, sapien", "19.00")

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
}


@Composable
fun ChatRoomHeader() {
    val navController = LocalNavController.current
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
                onClick = {
                    navController.navigate("main_screen")
                },
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
        horizontalAlignment = Alignment.End
    ) {
        Box(
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
                .padding(10.dp)
                .widthIn(max = 288.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Justify,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.black),
                modifier = Modifier
                    .padding(end = 45.dp)
            )
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            ) {
                Text(
                    text = "Dibaca",
                    fontSize = 11.sp,
                    color = colorResource(R.color.black),
                    lineHeight = 15.sp
                )
                Text(
                    text = time,
                    fontSize = 12.sp,
                    color = colorResource(R.color.black),
                    lineHeight = 15.sp
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
        horizontalAlignment = Alignment.Start
    ) {
        Box(
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
                .padding(10.dp)
                .widthIn(max = 288.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Justify,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.white),
                modifier = Modifier
                    .padding(end = 45.dp)
            )
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            ) {
                Text(
                    text = time,
                    fontSize = 12.sp,
                    color = colorResource(R.color.white),
                    lineHeight = 15.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}


@Composable
fun WriteMessageField() {
    var new_message by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.Bottom) {
        TextField(
            value = new_message,
            placeholder = {Text("Ketik pesan")},
            onValueChange = { new_message = it },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .border(
                    2.dp,
                    colorResource(R.color.primary),
                    RoundedCornerShape(30.dp)
                )
                .weight(6f)
                .heightIn(max = 200.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(R.color.gray),
                focusedContainerColor = colorResource(R.color.gray),
                unfocusedTextColor = colorResource(R.color.white),
                focusedTextColor = colorResource(R.color.white),
                unfocusedPlaceholderColor = colorResource(R.color.light_gray),
                focusedPlaceholderColor = colorResource(R.color.light_gray),
                cursorColor = colorResource(R.color.primary),
            ),


        )
        Button(
            onClick = {},
            modifier = Modifier
                .size(50.dp)
                .weight(1f),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.primary)
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.send_icon),
                contentDescription = "Tombol Kirim",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
