import config.Config

plugins {
    id("compose-module-setup")
}

android {
    namespace = Config.applicationId + ".designsystem"
}

kotlin {
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
        }

        commonMain.dependencies {
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.screenModel)
            implementation(libs.voyager.koin)
            implementation(projects.resources)
            implementation(libs.moko.compose.resources)
        }
    }
}

android {
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}
