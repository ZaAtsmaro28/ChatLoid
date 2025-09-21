package com.portfolio.chatloid.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItemData(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
