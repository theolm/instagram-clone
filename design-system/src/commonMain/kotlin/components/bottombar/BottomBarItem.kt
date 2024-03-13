package components.bottombar

import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource

data class BottomBarItem(
    val iconSelected: ImageResource,
    val iconUnselected: ImageResource,
    val contentDescription: StringResource,
    val borderColor: Color = Color.Transparent,
    val isImage: Boolean = false,
    val hasBorder: Boolean = false,
)