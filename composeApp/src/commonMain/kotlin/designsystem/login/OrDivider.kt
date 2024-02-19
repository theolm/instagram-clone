package designsystem.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import designsystem.colors.TextColor

@Composable
fun LoginDivider() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Divider(
            color = TextColor.BLACK_20A.color,
            thickness = 1.dp,
            modifier = Modifier
                .weight(4f)
                .padding(16.dp)
        )
        Text(
            text = "OR",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            color = TextColor.BLACK_40A.color
        )
        Divider(
            color = TextColor.BLACK_20A.color,
            thickness = 1.dp,
            modifier = Modifier
                .weight(4f)
                .padding(16.dp)
        )
    }
}
