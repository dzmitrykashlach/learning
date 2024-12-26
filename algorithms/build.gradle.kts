plugins {
    kotlin("jvm") version "2.0.0"
}

group = "org.homework"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val lombokVersion = "1.18.30"
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    implementation("org.projectlombok:lombok:$lombokVersion")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.0.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}