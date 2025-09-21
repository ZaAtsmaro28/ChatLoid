package com.portfolio.chatloid.view.addContact

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.R
import com.portfolio.chatloid.navigation.LocalNavController
import com.portfolio.chatloid.view.Buttons.BasicIconButton

@Preview
@Composable
fun AddContactScreen() {
    var text by remember { mutableStateOf("") }
    val navController = LocalNavController.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.white))
    ){
        Image(
            painter = painterResource(R.drawable.add_contact_asset1),
            contentScale = ContentScale.Crop,
            contentDescription = "Ilustrasi Dekorasi",
            modifier = Modifier
                .size(width = 600.dp, height = 520.dp)
                .offset(y = (-170).dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 20.dp, 16.dp, 0.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier.width(34.dp),
                    onClick = { navController.navigate("main_screen") },
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
                Text(
                    text = "Tambah Kontak",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.black)
                )
            }
            Text(
                text = "Anda bisa menambahkan teman melalui username ChatLoid mereka.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.black)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(R.drawable.add_contact_asset2),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Ilustrasi Dekorasi",
                    modifier = Modifier
                        .size(320.dp, 200.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextField(
                    value = text,
                    placeholder = {Text("username")},
                    onValueChange = { text = it },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = colorResource(R.color.white),
                        focusedContainerColor = colorResource(R.color.white),
                        unfocusedTextColor = colorResource(R.color.black),
                        focusedTextColor = colorResource(R.color.black),
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            2.dp,
                            colorResource(R.color.black),
                            RoundedCornerShape(8.dp)
                        )
                )
                Spacer(modifier = Modifier.height(4.dp))
                ElevatedButton(
                    onClick = {

                    },
                    elevation = ButtonDefaults.elevatedButtonElevation(4.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = colorResource(R.color.primary),
                        contentColor = colorResource(R.color.black)
                    ),
                    modifier = Modifier

                ) {
                    Text(
                        text = "Kirim Permintaan",
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = colorResource(R.color.black),
                        maxLines = 1
                    )
                }

            }

            Text(
                text = "Kontak akan secara otomatis ditambahkan setelah permintaan pertemanan disetujui oleh teman anda.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.black)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ChatLoid.com",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(R.color.black),

                    )
                Spacer(modifier = Modifier
                    .height(24.dp)
                    .background(Color.Red))
                Image(
                    painter = painterResource(R.drawable.add_contact_asset3),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Ilustrasi Dekorasi",
                    modifier = Modifier
                        .size(231.dp, 140.dp),

                    )
            }

        }
    }
}