package designsystem

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import designsystem.colors.TextColor

@Composable
fun HyperLinkText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    onClick: () -> Unit
) {
    Text(text = text, fontSize = 12.sp, fontWeight = fontWeight, color = TextColor.HYPERLINK_BLUE.color,
        modifier = modifier.clickable {
            onClick()
        }
    )
}
