package com.samples

import com.samples.service.FileProcessorMap
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
open class DemoApplication : CommandLineRunner {
    @Autowired
    lateinit var context: ApplicationContext

    override fun run(vararg args: String?) {
        (context.getBean("fileProcessorMap") as FileProcessorMap)
            .also { it.getImplasMap() }

    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}