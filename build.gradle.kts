import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

plugins {
    id("org.jetbrains.kotlin.jvm").version("1.6.10")
    id("io.gitlab.arturbosch.detekt").version("1.20.0")
}

repositories {
    mavenCentral()
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    config = files("$projectDir/detekt/detekt.yml")
    baseline = file("$projectDir/detekt/baseline.yml")
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
        xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
        txt.required.set(true) // similar to the console output, contains issue signature to manually edit baseline files
        sarif.required.set(true) // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
    }
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "11"
}
tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = "11"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("io.kotest:kotest-runner-junit5-jvm:5.3.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    testImplementation("io.kotest:kotest-assertions-core:5.3.1")
    testImplementation("io.kotest:kotest-property:5.3.1")
}
