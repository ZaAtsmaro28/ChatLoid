@file:OptIn(ExperimentalFoundationApi::class)

package com.portfolio.chatloid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.ui.theme.ChatLoidTheme
import kotlin.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatLoidTheme {
                Column(modifier = Modifier
                    .fillMaxWidth()

                ) {
                    HeaderApp("ChatLoid")
                    PageTab(listTab = tabItems)
                }
            }
        }
    }
}

@Composable
private fun HeaderApp(title: String, modifier: Modifier = Modifier) {
    Box(modifier
        .height(70.dp)
        .fillMaxWidth()
        .background(colorResource(R.color.gray))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            ) {
            Text(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                text = title,
                color = colorResource(R.color.primary)
            )
            Row(
                modifier = modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
                ) {
                NotificationButton()
                ImagePhotoProfile(painterResource(R.drawable.prof))
            }
        }
    }
}

@Composable
private fun NotificationButton(modifier: Modifier = Modifier) {
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

@Composable
private fun ImagePhotoProfile(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .size(48.dp) // atau ukuran lain yang konsisten
            .clip(CircleShape)
    )
}

data class TabItems(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)
val tabItems = listOf(
    TabItems(
        title = "Percakapan",
        unselectedIcon = Icons.Outlined.Chat,
        selectedIcon = Icons.Filled.Chat
    ),
    TabItems(
        title = "Kontak",
        unselectedIcon = Icons.Outlined.Contacts,
        selectedIcon = Icons.Filled.Contacts
    )
)
@Composable
private fun PageTab(listTab: List<TabItems>, modifier: Modifier = Modifier) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress){
            selectedTabIndex = pagerState.currentPage
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = colorResource(R.color.primary),
            contentColor = colorResource(R.color.black),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = colorResource(R.color.gray),
                    height = 2.dp
                )
            },
            divider = {
                Divider(
                    thickness = 1.dp,
                    color = Color.Gray
                )
            }
        ) {
            listTab.forEachIndexed { index, item ->
                Tab(
                    modifier = modifier.height(55.dp),
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        Text(
                            text = item.title,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title,
                            modifier = modifier.size(20.dp)
                        )
                    }
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = modifier.fillMaxSize().weight(1f)
        ) { index ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red),
                contentAlignment = Alignment.Center,

                ) {
                when (index) {
                    0 -> {
                        // Page 1
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
                        // Page 2
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(colorResource(R.color.white)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Halaman Kontak")
                        }
                    }
                }
            }
        }
    }
}

