package components.misc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import colors.TextColor
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR

@Composable
fun LoginFooter(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(color = TextColor.BLACK_20A.color, thickness = 0.5.dp)
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(MR.strings.login_footer), color = TextColor.BLACK_40A.color)
        }
    }
}
