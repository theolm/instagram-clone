package components.texts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR
import layout.horizontalPadding

@Composable
fun ForgotPasswordHyperlink() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        HyperLinkText(text = stringResource(MR.strings.forgot_password), fontWeight = FontWeight.W500) {
            /* TODO ADD NAVIGATION ACTION */
        }
    }
}
