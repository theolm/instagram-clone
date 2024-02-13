plugins {
    id("kmm-module-setup")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.theolm.temp"
}
dependencies {
    implementation("androidx.core:core-ktx:+")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.ktor.client.core)
            api(libs.ktor.client.negotiation)
            api(libs.ktor.serialization.json)
            implementation(libs.koin.core)
            implementation(libs.koin.test)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        desktopMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
    }
}