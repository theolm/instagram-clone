package `design-system`.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

val textColorBlack10A = Color(0x1A000000)

@Composable
fun CredentialInput(
    name: String,
    field: MutableState<String>,
    inputsState: MutableMap<String, Boolean>,
    loginButtonState: MutableState<Color>,
    inputType: KeyboardType
) {
    val inputMask = remember {
        mutableStateOf(if(inputType == KeyboardType.Text) VisualTransformation.None else PasswordVisualTransformation())
    }
    val passwordIcon = remember {
        mutableStateOf(Icons.Filled.Visibility)
    }
    val isEmail = inputType == KeyboardType.Text
    TextField(
        value = field.value, onValueChange = {
            field.value = it
            inputsState[if (isEmail) "email" else "password"] = field.value.isNotBlank()
            if (inputsState.values.all { state -> state }) {
                loginButtonState.value = activeLoginButtonColor
            } else {
                loginButtonState.value = inactiveLoginButtonColor
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = { Text(text = name) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = textColorBlack10A,
            placeholderColor = textColorBlack20A,
            textColor = Color(0xFF262626),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = textColorBlack20A
        ),
        shape = RoundedCornerShape(5.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = inputMask.value,
        trailingIcon = {
            if (!isEmail) {
                IconButton(onClick = {
                    passwordSwitch(passwordIcon, inputMask)
                }) {
                    Icon(passwordIcon.value,
                        tint = Color.Gray,
                        contentDescription = "Password visible"
                    )
                }
            }
        }
    )
}

fun passwordSwitch(
    icon: MutableState<ImageVector>,
    passwordMask: MutableState<VisualTransformation>
) {
    if (icon.value == Icons.Filled.VisibilityOff) {
        icon.value = Icons.Filled.Visibility
        passwordMask.value = PasswordVisualTransformation()
    } else {
        icon.value = Icons.Filled.VisibilityOff
        passwordMask.value = VisualTransformation.None
    }
}