package com.portfolio.chatloid.view.notification

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.portfolio.chatloid.model.NotifItemData

@Composable
fun NotifList(
    items : List<NotifItemData>,
    modifier : Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(horizontal = 12.dp)) {
        items.forEach { item ->
            item {
                NotifItemList(
                    image = painterResource(item.avatar) ,
                    name = item.name,
                    desc = item.desc,
                    isNeedAction = item.isNeedAction,
                    time = item.time
                )

            }
        }
    }
}