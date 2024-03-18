package components.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import colors.ButtonColor
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR

@Composable
fun LoginButton(
    loginButtonColor: ButtonColor,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(10),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = loginButtonColor.color,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(0.dp),
        onClick = onClick
    ) {
        Text(text = stringResource(MR.strings.login_button))
    }
}
