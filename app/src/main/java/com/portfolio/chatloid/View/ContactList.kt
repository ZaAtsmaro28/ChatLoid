package com.portfolio.chatloid.View

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.chatloid.Data.CategoryData
import com.portfolio.chatloid.R
import com.portfolio.chatloid.dummyData.names


val contactList = names.map {
    CategoryData(
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
        ) {
        Box(modifier = modifier.size(50.dp)){
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null,
                modifier = modifier.size(50.dp),
                tint = colorResource(R.color.black)
            )
        }
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
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategorizedLazyColumn(
    categories : List<CategoryData>,
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