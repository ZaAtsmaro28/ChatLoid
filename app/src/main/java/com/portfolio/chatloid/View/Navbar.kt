package com.portfolio.chatloid.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.Data.BottomNavigationItems
import com.portfolio.chatloid.R
import com.portfolio.chatloid.View.Buttons.AddContactFloatingButton

@Composable
fun BottomNavBar(modifier: Modifier = Modifier) {
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