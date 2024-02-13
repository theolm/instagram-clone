package common

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BottomBarComponent() {
    val homeTabState = remember {
        mutableStateOf(true)
    }
    val searchTabState = remember {
        mutableStateOf(false)
    }
    val likeTabState = remember {
        mutableStateOf(false)
    }
    val profileTabState = remember {
        mutableStateOf(false)
    }
    var profileBorderColor by remember {
        mutableStateOf(Color.Transparent)
    }
    val tabList = listOf(homeTabState, searchTabState, likeTabState, profileTabState)

    val iconModifier = Modifier
        .width(22.dp)
        .height(24.dp)
    Row(
        modifier = Modifier.background(Color.White).fillMaxWidth().height(45.dp).border(
            BorderStroke(width = 0.5.dp, color = Color(0x1A000000))
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(onClick = {
            selectSingleTab(homeTabState, tabList)
        }) {
            Icon(
                /*TODO WAITING ON MOKO DEPENDENCY*/
                //painterResource(if (homeTabState.value) R.drawable.home_selected else R.drawable.home_unselected),
                modifier = iconModifier,
                contentDescription = "Home Menu"
            )
        }
        IconButton(onClick = {
            selectSingleTab(searchTabState, tabList)
        }) {
            Icon(
                /*TODO WAITING ON MOKO DEPENDENCY*/
                //painterResource(if (searchTabState.value) R.drawable.search_selected else R.drawable.search_unselected),
                modifier = iconModifier,
                contentDescription = "Search Menu"
            )
        }
        IconButton(onClick = {
        }) {
            Icon(
                /*TODO WAITING ON MOKO DEPENDENCY*/
                //painterResource(R.drawable.add_new),
                modifier = iconModifier,
                contentDescription = "Add Menu"
            )
        }
        IconButton(onClick = {
            selectSingleTab(likeTabState, tabList)
        }) {
            Icon(
                /*TODO WAITING ON MOKO DEPENDENCY*/
                //painterResource(if (likeTabState.value) R.drawable.favorite_selected else R.drawable.favorite_unselected),
                modifier = iconModifier,
                contentDescription = "Favorite Icon"
            )
        }
        IconButton(modifier = Modifier
            .border(1.dp, profileBorderColor, RoundedCornerShape(100)).size(27.dp), onClick = {
            selectSingleTab(profileTabState, tabList)
        }) {
            profileBorderColor = if (profileTabState.value) Color.Black else Color.Transparent
            /*TODO ("Replace with dynamic obtained image from user")*/
            Image(
                /*TODO WAITING ON MOKO DEPENDENCY*/
                //painter = painterResource(id = R.drawable.avatar),
                modifier = iconModifier
                    .clip(RoundedCornerShape(100)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = "Profile Menu"
            )
        }
    }
}

fun selectSingleTab(selectedTab: MutableState<Boolean>, tabs: List<MutableState<Boolean>>) {
    tabs.forEach { tab -> tab.value = tab == selectedTab }
}