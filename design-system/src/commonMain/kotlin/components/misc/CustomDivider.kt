package components.misc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import colors.TextColor

@Composable
fun CustomDivider(
    text: String? = null,
    thickness: Dp = 1.0.dp,
    rowModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = rowModifier
    ) {
        LocalDivider(thickness)
        text?.let {
            Text(
                text = it,
                modifier = textModifier,
                textAlign = TextAlign.Center,
                color = TextColor.BLACK_40A.color,
            )
            LocalDivider(thickness)
        }
    }
}

@Composable
private fun RowScope.LocalDivider(thickness: Dp = 1.dp) {
    Divider(
        color = TextColor.BLACK_20A.color,
        thickness = thickness,
        modifier = Modifier.weight(1f)
    )
}
