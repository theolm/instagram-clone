package catalog

import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.screenModule

val designSystemScreenModule = screenModule {
    register<SharedScreen.CatalogScreen> {
        CatalogScreen()
    }
}

sealed class SharedScreen : ScreenProvider {
    data object CatalogScreen : SharedScreen()
}