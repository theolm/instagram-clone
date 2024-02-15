package prelogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import design_system.PrimaryMainButton
import design.ProfileIcon
import design.ProfileIconConfig
import design.TertiaryMainButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class PreLoginViewModel: ScreenModel {

}

class PreLoginScreen(
    private val profileImage: Painter,
    private val userName: String): Screen {
    @Composable
    override fun Content() {
        Screen()
    }
    @Composable
    private fun BottomContent() {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            Divider(color = Color(0xFF3C3C43),
                thickness = 1.dp,
                modifier = Modifier
                    .alpha(0.29f)
                    .fillMaxWidth())
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text("Don't have an account? ",
                    fontSize = 12.sp,
                    modifier = Modifier.alpha(0.4f))
                Text("Sign up",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF262626))
            }
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun Screen() {
        Scaffold(
            backgroundColor = Color.White,
            bottomBar = {
                BottomContent()
            }) {
            Column(
                modifier = Modifier.fillMaxSize(),
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