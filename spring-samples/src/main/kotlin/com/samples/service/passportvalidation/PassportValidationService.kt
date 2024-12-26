package com.samples.service.passportvalidation

import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@Service
class PassportValidationService(
    private val smev3service: Smev3Service,
    private val responseStorage: ResponseStorage
) {

    fun checkPassport(smev3Request: Smev3Request): String? {
        val messageId = smev3service.send(smev3Request).messageId
        responseStorage.add(messageId)
        return messageId
    }

    fun getResult(messageId: String, timeout: Long, timeUnit: TimeUnit): PassportCheckResult {
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