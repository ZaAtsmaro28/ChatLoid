package com.portfolio.chatloid.dummyData

import com.portfolio.chatloid.model.NotifItemData
import com.portfolio.chatloid.R

val notifList = listOf(
    NotifItemData(
        avatar = R.drawable.person1,
        name = "Aldova Ferdiansyah",
        desc = "menerima permintaan pertemanan anda.",
        time = "19.00",
        isNeedAction = false
    ),
    NotifItemData(
        avatar = R.drawable.person3,
        name = "Faza Atsmaro",
        desc = "mengirimi anda permintaan pertemanan.",
        time = "19.00",
        isNeedAction = true
    ),
)