package common.bottomBar

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR

val iconModifier = Modifier.width(22.dp).height(24.dp)

@Composable
fun BottomBar() {
    val homeItem = BottomBarItem(
        isSelected = mutableStateOf(true),
        iconSelected = MR.images.home_selected,
        iconUnselected = MR.images.home_unselected,
        contentDescription = MR.strings.desc_home_menu
    )
    val searchItem = BottomBarItem(
        iconSelected = MR.images.search_selected,
        iconUnselected = MR.images.search_unselected,
        contentDescription = MR.strings.desc_search_menu
    )
    val addItem = BottomBarItem(
        iconSelected = MR.images.add_new,
        iconUnselected = MR.images.add_new,
        contentDescription = MR.strings.desc_add_menu
    )
    val favoriteItem = BottomBarItem(
        iconSelected = MR.images.favorite_selected,
        iconUnselected = MR.images.favorite_unselected,
        contentDescription = MR.strings.desc_favorite_menu
    )
    val profileItem = BottomBarItem(
        iconSelected = MR.images.instagram_logo,
        iconUnselected = MR.images.instagram_logo,
        contentDescription = MR.strings.desc_profile_menu,
        borderColor = mutableStateOf(Color.Transparent)
    )

    val tabList = listOf(homeItem, searchItem, favoriteItem, profileItem)

    Row(
        modifier = Modifier.background(Color.White).fillMaxWidth().height(45.dp).border(
            BorderStroke(width = 0.5.dp, color = Color(0x1A000000))
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomBarIcon(item = homeItem, tabList = tabList)
        BottomBarIcon(item = searchItem, tabList = tabList)
        BottomBarIcon(item = addItem, tabList = tabList)
        BottomBarIcon(item = favoriteItem, tabList = tabList)
        BottomBarIcon(item = profileItem, tabList = tabList, isImage = true, hasBorder = true)
    }
}

@Composable
fun BottomBarIcon(item: BottomBarItem, tabList: List<BottomBarItem>, isImage: Boolean = false,
                  hasBorder: Boolean = false) {
    val modifier = if (hasBorder) Modifier.border(1.dp, item.borderColor.value,
        RoundedCornerShape(100)).size(27.dp) else iconModifier

    IconButton(modifier = modifier,
        onClick = {
            selectSingleTab(selectedTab = item, tabList = tabList)
        }) {
        if (isImage) {
            Image(
                painterResource(item.iconSelected),
                modifier = iconModifier.clip(RoundedCornerShape(100)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = stringResource(item.contentDescription)
            )
        } else {
            Icon(
                painterResource(if (item.isSelected.value) item.iconSelected else item.iconUnselected),
                modifier = iconModifier,
                contentDescription = stringResource(item.contentDescription)
            )
        }
    }
}

fun selectSingleTab(selectedTab: BottomBarItem, tabList: List<BottomBarItem>) {
    tabList.forEach { tab -> tab.isSelected.value = tab == selectedTab }
    if (selectedTab.contentDescription == MR.strings.desc_profile_menu) {
        selectedTab.borderColor.value = Color.Black
    } else {
        tabList.forEach { tab -> tab.borderColor.value = Color.Transparent }
    }
}