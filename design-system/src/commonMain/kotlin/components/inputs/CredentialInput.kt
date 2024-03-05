package components.inputs

import colors.ButtonColor
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import dev.icerock.moko.resources.compose.painterResource
import instaclone.resources.MR

@Composable
fun CredentialInput(
    name: String,
    field: MutableState<String>,
    inputsState: MutableMap<String, Boolean>,
    loginButtonState: MutableState<ButtonColor>,
    inputType: KeyboardType
) {
    val inputMask = remember {
        mutableStateOf(if(inputType == KeyboardType.Text) VisualTransformation.None else PasswordVisualTransformation())
    }
    val passwordIcon = remember {
        mutableStateOf(MR.images.visibility_on)
    }
    val isEmail = inputType == KeyboardType.Text
    TextField(
        value = field.value, onValueChange = {
            field.value = it
            inputsState[if (isEmail) "email" else "password"] = field.value.isNotBlank()
            if (inputsState.values.all { state -> state }) {
                loginButtonState.value = ButtonColor.BLUE_100A
            } else {
                loginButtonState.value = ButtonColor.BLUE_50A
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = { Text(text = name) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = TextColor.BLACK_10A.color,
            placeholderColor = TextColor.BLACK_20A.color,
            textColor = TextColor.DARK_GRAY.color,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = TextColor.BLACK_20A.color,
        ),
        shape = RoundedCornerShape(5.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = inputMask.value,
        trailingIcon = {
            if (!isEmail) {
                IconButton(onClick = {
                    passwordSwitch(passwordIcon, inputMask)
                }) {
                    Icon(
                        painterResource(passwordIcon.value),
                        tint = Color.Gray,
                        contentDescription = "Password visible"
                    )
                }
            }
        }
    )
}

fun passwordSwitch(
    icon: MutableState<ImageResource>,
    passwordMask: MutableState<VisualTransformation>
) {
    if (icon.value == MR.images.visibility_off) {
        icon.value = MR.images.visibility_on
        passwordMask.value = PasswordVisualTransformation()
    } else {
        icon.value = MR.images.visibility_off
        passwordMask.value = VisualTransformation.None
    }
}
