package components.bottombar

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
import androidx.compose.material.Surface
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



private val tabItems = listOf(
    BottomBarItem(
        iconSelected = MR.images.home_selected,
        iconUnselected = MR.images.home_unselected,
        contentDescription = MR.strings.desc_home_menu
    ),
    BottomBarItem(
        iconSelected = MR.images.search_selected,
        iconUnselected = MR.images.search_unselected,
        contentDescription = MR.strings.desc_search_menu
    ),
    BottomBarItem(
        iconSelected = MR.images.add_new,
        iconUnselected = MR.images.add_new,
        contentDescription = MR.strings.desc_add_menu
    ),
    BottomBarItem(
        iconSelected = MR.images.favorite_selected,
        iconUnselected = MR.images.favorite_unselected,
        contentDescription = MR.strings.desc_favorite_menu
    ),
    BottomBarItem(
        iconSelected = MR.images.instagram_logo,
        iconUnselected = MR.images.instagram_logo,
        contentDescription = MR.strings.desc_profile_menu,
        borderColor = Color.Black,
        hasBorder = true,
        isImage = true,
    )
)

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selectedTabIndex: Int = 0,
    onTabSelected: (Int) -> Unit
) {
    Surface(
        elevation = 6.dp
    ) {
        Row(
            modifier = modifier
                .background(Color.White)
                .height(45.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            tabItems.forEachIndexed { index, bottomBarItem ->
                BottomBarIcon(
                    item = bottomBarItem,
                    isSelected = index == selectedTabIndex
                ) {
                    onTabSelected(index)
                }
            }
        }
    }
}

@Composable
fun BottomBarIcon(
    item: BottomBarItem,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    val iconModifier = Modifier.width(22.dp).height(24.dp)
    val roundedShape = RoundedCornerShape(100)

    val modifier = if (item.hasBorder) Modifier.border(
        width = 1.dp,
        color = if (isSelected) item.borderColor else Color.Transparent,
        shape = roundedShape
    ).size(27.dp) else iconModifier

    IconButton(
        modifier = modifier,
        onClick = onItemClick
    ) {
        if (item.isImage) {
            Image(
                painter = painterResource(item.iconSelected),
                modifier = iconModifier.clip(roundedShape),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = stringResource(item.contentDescription)
            )
        } else {
            Icon(
                painter = painterResource(if (isSelected) item.iconSelected else item.iconUnselected),
                modifier = iconModifier,
                contentDescription = stringResource(item.contentDescription)
            )
        }
    }
}
