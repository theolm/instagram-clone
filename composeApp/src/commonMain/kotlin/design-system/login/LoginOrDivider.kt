package `design-system`.login

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
import com.theolm.instaclone.textColorBlack20A
import com.theolm.instaclone.textColorBlack40A

@Composable
fun LoginDivider() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Divider(
            color = textColorBlack20A,
            thickness = 1.dp,
            modifier = Modifier
                .weight(4f)
                .padding(16.dp)
        )
        Text(
            text = "OR",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            color = textColorBlack40A
        )
        Divider(
            color = textColorBlack20A,
            thickness = 1.dp,
            modifier = Modifier
                .weight(4f)
                .padding(16.dp)
        )
    }
}