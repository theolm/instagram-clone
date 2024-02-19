plugins {
    id("kmm-module-setup")
    alias(libs.plugins.resourcesMultiplatform)
}

android {
    namespace = "resources"
}

kotlin {
    dependencies {
        sourceSets {
            commonMain.dependencies {
                implementation(libs.moko.resources)
            }

            androidMain {
                dependsOn(commonMain.get())
            }

            iosMain {
                dependsOn(commonMain.get())
            }

            desktopMain {
                dependsOn(commonMain.get())
            }
        }
    }
}