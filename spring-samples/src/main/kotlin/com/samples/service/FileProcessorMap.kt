package com.samples.service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.function.Consumer
import javax.annotation.PostConstruct

@Component
class FileProcessorMap @Autowired constructor(private val storeServices: Map<String, StorageService>) {
    @PostConstruct
    fun getImplasMap() {
        storeServices
            .forEach { (id, storageService) -> println(id + ": " + storageService.javaClass.simpleName) }
    }
}

@Component
class FileProcessorList @Autowired constructor(private val storeServices: List<StorageService>) {
    @PostConstruct
    fun getImplasList() {
        storeServices
            .forEach(Consumer { storageService: StorageService ->
                println(
                    storageService.javaClass.simpleName
                )
            })
    }
}