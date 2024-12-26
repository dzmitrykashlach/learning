package com.samples.service.passportvalidation

data class Smev3Request(
    val pluginMnemonic: String,
    val requestContent: PassportRequestContent
)

data class PassportRequestContent(
    val series: String,
    val number: String,
    val IssuerDate: Long
)

data class ResponseContent(
    val validDoc: Boolean? = false
)
