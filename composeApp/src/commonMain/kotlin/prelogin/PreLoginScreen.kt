package prelogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import design.PrimaryMainButton
import design.ProfileIcon
import design.ProfileIconConfig
import design.TertiaryMainButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class PreLoginScreen(
    private val profileImage: Painter,
    private val userName: String): Screen {
    @Composable
    override fun Content() {
        Screen()
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun Screen() {
        Surface(modifier = Modifier
            .fillMaxSize(),
            color = Color.White
            ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier.size(
                        width = 182.dp,
                        height = 48.dp
                    ),
                    painter = painterResource("Instagram Logo@3x.png"),
                    contentDescription = null
                )
                ProfileIcon(
                    modifier = Modifier.padding(top = 48.dp),
                    input = ProfileIconConfig.Input(image = profileImage, username = userName),
                    context = ProfileIconConfig.Context.PreLogin
                )
                PrimaryMainButton(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    text = "Log in",
                    onClick = { }
                )
                TertiaryMainButton(
                    modifier = Modifier.padding(12.dp),
                    text = "Switch accounts",
                    onClick = { }
                )
            }
        }
    }
}