package com.samples

import com.samples.service.passportvalidation.PassportRequestContent
import com.samples.service.passportvalidation.PassportValidationService
import com.samples.service.passportvalidation.Smev3Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.TimeUnit
import kotlin.test.Test

@SpringBootTest
class PassportValidationTest {
    @Autowired
    lateinit var passportValidationService: PassportValidationService

    @Test
    fun validatePassport(){
        val smev3Request = Smev3Request(
            pluginMnemonic = "passportValidator",
            requestContent = PassportRequestContent(
                series = "MC",
                number = "1234567",
                IssuerDate = System.currentTimeMillis()
            )
        )
        val requestId = passportValidationService.checkPassport(smev3Request)
        val checkResult = passportValidationService.getResult(requestId, 20, TimeUnit.SECONDS)
        println(checkResult)
    }
}