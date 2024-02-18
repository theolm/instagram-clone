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
            /**
             * Use to avoid Expected object 'MR' has no actual declaration in module
             * - https://github.com/icerockdev/moko-resources/issues/531
             */
            androidMain {
                dependsOn(commonMain.get())
            }
        }
    }
}