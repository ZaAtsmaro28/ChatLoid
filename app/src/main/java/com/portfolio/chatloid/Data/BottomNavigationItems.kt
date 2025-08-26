package com.portfolio.chatloid.Data

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItems(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
