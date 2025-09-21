package com.portfolio.chatloid.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.portfolio.chatloid.model.ChatListItemData
import com.portfolio.chatloid.R

@Composable
fun ChatList(
    items : List<ChatListItemData>,
    modifier : Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items.forEach { item ->
            item {
                ChatItemList(
                    image = painterResource(item.avatar) ,
                    name = item.name,
                    previewChat = item.previewChat,
                    time = item.time
                )
                Box(Modifier
                    .height(1.dp)
                    .background(colorResource(R.color.gray))
                    .fillMaxWidth())
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}