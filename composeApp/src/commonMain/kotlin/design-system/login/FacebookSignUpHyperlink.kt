package `design-system`.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.theolm.instaclone.R
import com.theolm.instaclone.components.HyperLinkText

@Composable
fun FacebookSignUpHyperlink() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.facebook_logo),
            contentDescription = "Facebook logo"
        )
        HyperLinkText(
            modifier = Modifier.padding(start = 10.dp),
            text = stringResource(R.string.facebook_login), fontWeight = FontWeight.W600
        ) {
            /* TODO ADD NAVIGATION ACTION */
        }

    }
}