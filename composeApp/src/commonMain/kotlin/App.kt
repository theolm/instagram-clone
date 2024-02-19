import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.Navigator
import catalog.designSystemScreenModule
import home.HomeScreen

@Composable
fun App() {
    /**
     * Register the screen entry points for each module.
     */
    ScreenRegistry {
        designSystemScreenModule()
    }

    MaterialTheme {
        Navigator(HomeScreen())
    }
}
