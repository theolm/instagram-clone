package `design-system`.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.theolm.instaclone.R

@Composable
fun InstagramLogo() {
    Image(
        modifier = Modifier.padding(top = 60.dp, bottom = 40.dp),
        painter = painterResource(id = R.drawable.instagram_text_logo),
        contentDescription = "Instagram text logo"
    )
}