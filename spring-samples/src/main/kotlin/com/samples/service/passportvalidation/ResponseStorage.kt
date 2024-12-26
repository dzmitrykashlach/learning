package com.samples.service.passportvalidation

import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap

@Component
class ResponseStorage(
    val smev3Service: Smev3Service
) {
    private val results = ConcurrentHashMap<String, CompletableFuture<PassportCheckResult>>()

    fun add(requestId: String,) {
        results.put(
            requestId,
            CompletableFuture.supplyAsync {
                smev3Service.get(requestId)
            }
        )
    }

    fun get(requestId: String?): CompletableFuture<PassportCheckResult>? {
        return results.get(requestId)
    }

    fun remove(requestId: String) {
        results.remove(requestId)
    }
}