package com.samples.service.passportvalidation

data class PassportCheckResult(
    val clientId: String,
    val replyToClientId: String,
    val messageId: String,
    val responseContent: ResponseContent
)
