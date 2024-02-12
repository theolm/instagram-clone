package `design-system`.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

val horizontalPadding = 16.dp
val activeLoginButtonColor = Color(0xFF3797EF)
val inactiveLoginButtonColor = Color(0x803797EF)
val textColorBlack20A = Color(0x2A000000)
val textColorBlack40A = Color(0x4A000000)

@Composable
fun LoginActivity() {
    val emailTextField = remember {
        mutableStateOf("")
    }
    val passwordTextField = remember {
        mutableStateOf("")
    }
    val loginButtonState = remember {
        mutableStateOf(inactiveLoginButtonColor)
    }
    val inputsState = remember {
        mutableMapOf("email" to false, "password" to false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(modifier = Modifier.padding(top = 10.dp)) {
            IconButton(onClick = {
                /* TODO ADD NAVIGATION ACTION */
            }) {
                Icon(
                    Icons.Sharp.ArrowBackIos,
                    contentDescription = "Go back"
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstagramLogo()
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CredentialInput(
                    name = stringResource(R.string.user_login_placeholder),
                    field = emailTextField,
                    inputsState = inputsState,
                    inputType = KeyboardType.Text,
                    loginButtonState = loginButtonState
                )

                Spacer(modifier = Modifier.size(15.dp))

                CredentialInput(
                    name = stringResource(R.string.user_password_placeholder),
                    field = passwordTextField,
                    inputsState = inputsState,
                    inputType = KeyboardType.Password,
                    loginButtonState = loginButtonState
                )

                Spacer(modifier = Modifier.size(15.dp))

                ForgotPasswordHyperlink()
                LoginButton(loginButtonState, inputsState)
                FacebookSignUpHyperlink()
                LoginDivider()
                InstagramSignUpHyperlink()
            }
        }
    }
    LoginFooter()
}