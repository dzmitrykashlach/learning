val coroutines_version: String by project

plugins {
    id("java")
    kotlin("jvm") version "2.0.0"

}

group = "com.algorithms.multithreading"

repositories {
    mavenCentral()
}

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
        testImplementation(kotlin("test"))
    }

kotlin {
    jvmToolchain(17)
}