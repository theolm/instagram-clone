package plugins

import config.Config
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("io.gitlab.arturbosch.detekt")
}

val libs = the<LibrariesForLibs>()
dependencies {
    detektPlugins(libs.detekt.rules.formatting)
    detektPlugins(libs.detekt.rules.compose)
}

private val projectSource = file("$rootDir")
private val configFile = files("$rootDir/config/detekt/detekt.yml")
private val baselineFile = file("$rootDir/config/detekt/baseline.xml")
private val kotlinFiles = "**/*.kt"
private val resourceFiles = "**/resources/**"
private val buildFiles = "**/build/**"
private val generatedFiles = "**/generated/**"
private val scriptsFiles = "**/*.kts"

detekt {
    buildUponDefaultConfig = true
    parallel = true
    autoCorrect = true
    ignoreFailures = false
    config.setFrom(configFile)
    baseline = file(baselineFile)
    source.from(projectSource)
}

tasks.withType<Detekt>().configureEach {
    include(kotlinFiles)
    exclude(resourceFiles, buildFiles, generatedFiles, scriptsFiles)
    reports {
        html.required.set(true)
        xml.required.set(false)
        txt.required.set(false)
    }
    jvmTarget = Config.javaVersion.toString()
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = Config.javaVersion.toString()
}
