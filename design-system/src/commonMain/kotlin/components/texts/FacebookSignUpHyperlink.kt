package components.texts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR

@Composable
fun FacebookSignUpHyperlink(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(20.dp)
    ) {
        Image(
            painter = painterResource(MR.images.facebook_logo),
            contentDescription = stringResource(MR.strings.facebook_logo)
        )
        HyperLinkText(
            modifier = modifier,
            text = stringResource(MR.strings.facebook_login), fontWeight = FontWeight.W600
        ) {
            /* TODO ADD NAVIGATION ACTION */
        }

    }
}
