package components.texts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import colors.TextColor
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR

@Composable
fun InstagramSignUpHyperlink() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(MR.strings.cta_no_account),
            modifier = Modifier.padding(end = 5.dp),
            color = TextColor.BLACK_40A.color,
            fontSize = 12.sp
        )
        HyperLinkText(text = stringResource(MR.strings.sign_up_cta)) {
            /* TODO ADD NAVIGATION ACTION */
        }
    }
}
