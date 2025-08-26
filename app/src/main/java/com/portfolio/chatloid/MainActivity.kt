@file:OptIn(ExperimentalFoundationApi::class)

package com.portfolio.chatloid

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Layout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.ui.theme.ChatLoidTheme
import org.w3c.dom.Text
import kotlin.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatLoidTheme {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)

                ) {
                    BottomNavBar()
                }
            }
        }
    }
}

@Composable
private fun HeaderApp(title: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(70.dp)
            .fillMaxWidth()
            .background(colorResource(R.color.gray))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 10.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            ) {
            Text(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                text = title,
                color = colorResource(R.color.primary)
            )
            NotificationButton()
        }
        Divider(
            color = colorResource(R.color.primary),
            thickness = 2.dp,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun NotificationButton() {
    Button(
        onClick = {
            print("Test")
        },
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            modifier = Modifier.size(28.dp),
            contentDescription = "Tombol Notifikasi",
            tint = colorResource(R.color.white)
        )
    }
}

data class BottomNavigationItems(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
@Composable
private fun BottomNavBar(modifier: Modifier = Modifier) {
    val items = listOf(
        BottomNavigationItems(
            title = "Percakapan",
            unselectedIcon = Icons.Outlined.Chat,
            selectedIcon = Icons.Filled.Chat,
            hasNews = false,
            badgeCount = 12
        ),
        BottomNavigationItems(
            title = "Kontak",
            unselectedIcon = Icons.Outlined.Contacts,
            selectedIcon = Icons.Filled.Contacts,
            hasNews = false
        ),
        BottomNavigationItems(
            title = "Profile",
            unselectedIcon = Icons.Outlined.AccountCircle,
            selectedIcon = Icons.Filled.AccountCircle,
            hasNews = true
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val pagerState = rememberPagerState {
        3
    }

    LaunchedEffect(selectedItemIndex) {
        pagerState.animateScrollToPage(selectedItemIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress){
            selectedItemIndex = pagerState.currentPage
        }
    }

    Scaffold(
        topBar = { HeaderApp(title = "ChatLoid") },
        bottomBar = {
            NavigationBar(containerColor = colorResource(R.color.gray)) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                        },
                        label = {
                            Text(text = item.title)
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null){
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    }
                                    else if (item.hasNews){
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector =
                                        if (index == selectedItemIndex){
                                            item.selectedIcon
                                        } else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        },
                        colors = NavigationBarItemDefaults
                            .colors(
                                selectedIconColor = colorResource(R.color.primary),
                                selectedTextColor = colorResource(R.color.primary),
                                unselectedIconColor = colorResource(R.color.primary),
                                unselectedTextColor = colorResource(R.color.primary),
                                indicatorColor = colorResource(R.color.black)
                                ),

                        )
                }
            }
        }
    ) { innerPadding: PaddingValues ->
        Column {
            HorizontalPager(
                state = pagerState,
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red),
                    contentAlignment = Alignment.Center,

                    ) {
                    when (index) {
                        0 -> {
                            // chat_list_page
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(colorResource(R.color.white)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Halaman Percakapan")
                            }
                        }
                        1 -> {
                            // contact_page
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(colorResource(R.color.white)),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Column(modifier = modifier.padding(16.dp, 4.dp)) {
                                    Text(
                                        text = "Pilih Kontak",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(R.color.black)
                                    )
                                    Spacer(modifier.height(3.dp))
                                    Text(
                                        text = "123 Kontak",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(R.color.black)
                                    )

                                }


                                CategorizedLazyColumn(categories = contactList)
                            }
                            AddContactFloatingButton()
                        }
                        2 -> {
                            // profile_page
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(colorResource(R.color.white)),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                                ) {
                                ProfilePage()
                            }
                        }
                    }
                }
            }
        }
    }
}


data class Category (
    val name : String,
    val items : List<String>
)

val contactList = names.map {
    Category(
        name = it.key.toString(),
        items = it.value
    )
}

@Composable
private fun CategoryHeader(
    text : String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.black),
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(R.color.secondary))
            .padding(16.dp, 5.dp)
    )
}

@Composable
private fun CategoryItem(
    text : String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = colorResource(R.color.black),
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(R.color.white))
            .padding(16.dp)
    )
}

@Composable
private fun CategorizedLazyColumn(
    categories : List<Category>,
    modifier : Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        categories.forEach { category ->
            stickyHeader {
                CategoryHeader(category.name)
            }
            items(category.items) { text ->
                CategoryItem(text)
            }
        }
    }
}

@Composable
private fun AddContactFloatingButton(modifier: Modifier = Modifier) {
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

@Composable
private fun ProfilePage(modifier: Modifier = Modifier){
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
            ){
                ProfileActionButton()
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
private fun ProfileActionButton(modifier: Modifier = Modifier){
    var onEditMode by remember {
        mutableStateOf(false)
    }
    var button_text = ""
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopEnd) {
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

@Composable
private fun ProfilePhoto(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .size(140.dp)
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


