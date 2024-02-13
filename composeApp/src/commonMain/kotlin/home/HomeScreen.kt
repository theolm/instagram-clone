package home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import design.PrimaryMainButton
import design.PrimaryMainButtonConfig
import design.ProfileIcon
import design.ProfileIconConfig
import design.TertiaryMainButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        Screen()
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    private fun Screen() {
        val screenModel = getScreenModel<HomeScreenModel>()
        var uiState by screenModel.uiState

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {
                    uiState = uiState.copy(showContent = !uiState.showContent)
                }
            ) {
                Text("Click me!")
            }
            PrimaryMainButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "Click",
                image = painterResource("facebook-logo.png"),
                imageAlignment = PrimaryMainButtonConfig.ImageAlignment.END,
                onClick = {
                uiState = uiState.copy(showContent = !uiState.showContent)
            })

            TertiaryMainButton(
                text = "Switch accounts",
                onClick = {
                    uiState = uiState.copy(showContent = !uiState.showContent)
                })

            ProfileIcon(
                modifier = Modifier
                .padding(top = 32.dp),
                input = ProfileIconConfig.Input(image = painterResource(
                    "pedro.jpeg"),
                    username = "eupedroalvarez"),
                context = ProfileIconConfig.Context.PreLogin)

            AnimatedVisibility(uiState.showContent) {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource("compose-multiplatform.xml"), null)
                    Text("Compose: ${uiState.message}")
                }
            }
        }
    }
}