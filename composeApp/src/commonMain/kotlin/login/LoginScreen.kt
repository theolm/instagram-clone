package login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import colors.ButtonColor
import components.buttons.LoginButton
import components.inputs.PasswordInput
import components.inputs.UsernameInput
import components.misc.LoginDivider
import components.misc.LoginFooter
import components.texts.FacebookSignUpHyperlink
import components.texts.ForgotPasswordHyperlink
import components.texts.InstagramSignUpHyperlink
import components.texts.InstagramTextLogo
import dev.icerock.moko.resources.compose.painterResource
import instaclone.resources.MR
import layout.horizontalPadding

@Composable
fun LoginScreen() {
    val usernameTextField = remember {
        mutableStateOf("")
    }
    val passwordTextField = remember {
        mutableStateOf("")
    }
    val loginButtonState = remember {
        mutableStateOf(ButtonColor.BLUE_50A)
    }
    val inputFields: List<MutableState<String>> = listOf(usernameTextField, passwordTextField)

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
                UsernameInput(
                    inputField = usernameTextField,
                )

                Spacer(modifier = Modifier.size(15.dp))

                PasswordInput(
                    inputField = passwordTextField
                )

                Spacer(modifier = Modifier.size(15.dp))

                ForgotPasswordHyperlink()
                LoginButton(loginButtonState = loginButtonState, inputFields = inputFields,
                    modifier = Modifier.fillMaxWidth().padding(horizontalPadding), onClick = {
                        if (inputFields.all { input -> input.value.isNotBlank() }) {
                            try {
                                /* TODO ADD NAVIGATION ACTION */
                            } catch (response: Exception) {
                                /*TODO CREATE ALERT DIALOG*/
                            }
                        }
                    })
                FacebookSignUpHyperlink(modifier = Modifier.padding(start = 10.dp))
                LoginDivider()
                InstagramSignUpHyperlink()
            }
        }
    }
    LoginFooter(modifier = Modifier.fillMaxWidth().padding(30.dp))
}
