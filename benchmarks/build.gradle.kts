@file:Suppress("UnstableApiUsage")

import kotlinx.benchmark.gradle.*
import org.jetbrains.kotlin.allopen.gradle.*

 plugins {
     java
     kotlin("jvm") version "2.0.0"
     kotlin("plugin.allopen") version "2.0.0"
     id("org.jetbrains.kotlinx.benchmark") version "0.4.7"
}

group = "com.algorithms.benchmarks"
 kotlin {
     jvmToolchain(17)
 }
sourceSets.all {
    java.setSrcDirs(listOf("$name/src"))
    resources.setSrcDirs(listOf("$name/resources"))
}
repositories {
    mavenCentral()
}


configure<AllOpenExtension> {
    annotation("org.openjdk.jmh.annotations.State")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("commons-io:commons-io:2.11.0")
    implementation("org.jctools:jctools-core:4.0.5")
}

benchmark {
    configurations {
        named("main") {
            warmups = 3
            iterations = 3
            iterationTimeUnit = "ms"
            outputTimeUnit = "ms"
            reportFormat = "csv"
//            outputTimeUnit = "nanos"
            mode = "avgt"
//            include("bitwise.PowerSetBenchmark*")
            include("multithreading.threadpool.*")
        }
    }
    targets {
        register("main") {
            this as JvmBenchmarkTarget
            jmhVersion = "1.21"
        }
    }
}

java.sourceSets.getByName("main"){
    java.srcDir("src/main/kotlin")
}
java.sourceSets.getByName("test"){
    java.srcDir("src/test/kotlin")
}
