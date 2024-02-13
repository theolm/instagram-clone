import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import home.HomeScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import prelogin.PreLoginScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Navigator(PreLoginScreen(
            profileImage = painterResource("pedro.jpeg"),
            userName = "eupedroalvarez")
        )
    }
}
