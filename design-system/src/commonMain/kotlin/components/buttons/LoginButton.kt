package components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import colors.ButtonColor
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR
import layout.horizontalPadding

@Composable
fun LoginButton(loginButtonState: MutableState<ButtonColor>, inputsState: MutableMap<String, Boolean>) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontalPadding),
        shape = RoundedCornerShape(10),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = loginButtonState.value.color,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(0.dp),
        onClick = {
            if (inputsState.values.all { state -> state }) {
                try {
                    /* TODO ADD NAVIGATION ACTION */
                } catch (response: Exception) {
                    /*TODO CREATE ALERT DIALOG*/
                }
            }
        }) {
        Text(text = stringResource(MR.strings.login_button))
    }
}
