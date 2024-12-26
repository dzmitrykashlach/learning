plugins {
    kotlin("jvm") version "2.0.0"
}

group = "org.homework"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-context:6.2.2")
    implementation("org.springframework.boot:spring-boot-autoconfigure:3.4.2")
    implementation("javax.annotation:javax.annotation-api:1.3.2")


    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.2")
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}