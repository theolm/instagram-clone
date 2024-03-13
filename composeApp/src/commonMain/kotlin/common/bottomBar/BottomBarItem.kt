package common.bottomBar

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource

data class BottomBarItem(
    val isSelected: MutableState<Boolean> = mutableStateOf(false),
    val iconSelected: ImageResource,
    val iconUnselected: ImageResource,
    val contentDescription: StringResource,
    val borderColor: MutableState<Color> = mutableStateOf(Color.Transparent)
)