package login

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import designsystem.colors.ButtonColor
import designsystem.login.CredentialInput
import designsystem.login.FacebookSignUpHyperlink
import designsystem.login.ForgotPasswordHyperlink
import designsystem.login.InstagramTextLogo
import designsystem.login.InstagramSignUpHyperlink
import designsystem.login.LoginButton
import designsystem.login.LoginDivider
import designsystem.login.LoginFooter
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import instaclone.resources.MR

val horizontalPadding = 16.dp

@Composable
fun LoginScreen() {
    val emailTextField = remember {
        mutableStateOf("")
    }
    val passwordTextField = remember {
        mutableStateOf("")
    }
    val loginButtonState = remember {
        mutableStateOf(ButtonColor.BLUE_50A)
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
                    painterResource(MR.images.arrow_back),
                    contentDescription = "Go back"
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstagramTextLogo()
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CredentialInput(
                    name = stringResource(MR.strings.user_login_placeholder),
                    field = emailTextField,
                    inputsState = inputsState,
                    inputType = KeyboardType.Text,
                    loginButtonState = loginButtonState
                )

                Spacer(modifier = Modifier.size(15.dp))

                CredentialInput(
                    name = stringResource(MR.strings.user_password_placeholder),
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
