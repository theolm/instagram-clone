package `design-system`.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.theolm.instaclone.R
import com.theolm.instaclone.components.HyperLinkText
import com.theolm.instaclone.textColorBlack40A

@Composable
fun InstagramSignUpHyperlink() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.no_account_cta),
            modifier = Modifier.padding(end = 5.dp),
            color = textColorBlack40A
        )
        HyperLinkText(text = stringResource(R.string.sign_up_cta)) {
            /* TODO ADD NAVIGATION ACTION */
        }
    }
}