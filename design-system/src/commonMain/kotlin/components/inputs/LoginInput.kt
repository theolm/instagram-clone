package components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import colors.TextColor
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR
import layout.horizontalPadding

@Composable
fun UsernameInput(
    inputField: String,
    onTextChange: (String) -> Unit
) {
    TextField(
        value = inputField, onValueChange = {
            onTextChange(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding),
        placeholder = { Text(text = stringResource(MR.strings.placeholder_user_login)) },
        colors = getTextFieldColors(),
        shape = RoundedCornerShape(5.dp),
    )
}

@Composable
fun PasswordInput(
    inputField: String,
    onTextChange: (String) -> Unit
) {
    val passwordMask = remember {
        mutableStateOf<VisualTransformation>(PasswordVisualTransformation())
    }
    val passwordIcon = remember {
        mutableStateOf(MR.images.visibility_on)
    }
    val contentDescriptionIcon = remember {
        mutableStateOf(MR.strings.password_visible)
    }

    TextField(
        value = inputField, onValueChange = {
            onTextChange(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding),
        placeholder = { Text(text = stringResource(MR.strings.placeholder_user_password)) },
        colors = getTextFieldColors(),
        shape = RoundedCornerShape(5.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = passwordMask.value,
        trailingIcon = {
                IconButton(onClick = {
                    passwordSwitch(passwordIcon, passwordMask, contentDescriptionIcon)
                }) {
                    Icon(
                        painterResource(passwordIcon.value),
                        tint = Color.Gray,
                        contentDescription = stringResource(contentDescriptionIcon.value)
                    )
                }
        }
    )
}

private fun passwordSwitch(
    icon: MutableState<ImageResource>,
    passwordMask: MutableState<VisualTransformation>,
    contentDescriptionIcon: MutableState<StringResource>
) {
    if (icon.value == MR.images.visibility_off) {
        icon.value = MR.images.visibility_on
        passwordMask.value = PasswordVisualTransformation()
        contentDescriptionIcon.value = MR.strings.password_visible
    } else {
        icon.value = MR.images.visibility_off
        passwordMask.value = VisualTransformation.None
        contentDescriptionIcon.value = MR.strings.password_not_visible
    }
}

@Composable
private fun getTextFieldColors(): TextFieldColors {
    return TextFieldDefaults.textFieldColors(backgroundColor = TextColor.BLACK_10A.color,
        placeholderColor = TextColor.BLACK_20A.color,
        textColor = TextColor.DARK_GRAY.color,
        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        cursorColor = TextColor.BLACK_20A.color,)
}