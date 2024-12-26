package com.samples.service.passportvalidation

import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@Service
class PassportValidationService(
    private val smev3service: Smev3Service,
    private val responseStorage: ResponseStorage
) {
//    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun checkPassport(smev3Request: Smev3Request): String? {
        val messageId = smev3service.send(smev3Request).messageId
        responseStorage.add(
            messageId
        )
        /*
            val passportCheckResult = responseStorage.get(messageId)?.get(20000L, TimeUnit.SECONDS)

            scope.launch {
            val delays = listOf(3_000L, 5_000L, 10_000L, 15_000L)
            var response: Smev3Response? = null

            for (delay in delays) {
                delay(delay) // Non-blocking delay
                try {
                    response = smev3service.get(messageId)
                    if (response != null) break
                } catch (e: Exception) {
                    // Handle temporary errors, continue polling
                }
            }
            response?.let {
                responseStorage.add(messageId, response)
            } ?: responseStorage.add(
                messageId,
                TimeoutException("No response received within timeout period")
            )
        }

        */
        return messageId
    }

    fun getResult(messageId: String?, timeout: Long, timeUnit: TimeUnit): PassportCheckResult {
        val responseFuture = responseStorage.get(messageId)
        return if (responseFuture != null) {
            try {
                responseFuture.get(timeout, timeUnit)
            } catch (e: TimeoutException) {
                throw IllegalStateException("Timeout exception for messageId = $messageId", e)
            }
        } else {
            throw IllegalStateException("No result for request $messageId")
        }
    }
}