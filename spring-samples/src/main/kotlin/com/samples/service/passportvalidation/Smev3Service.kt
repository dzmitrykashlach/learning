package com.samples.service.passportvalidation

import org.springframework.stereotype.Service
import java.util.UUID

/* TODO

https://info.gosuslugi.ru/articles/%D0%98%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5_%D0%BF%D0%BB%D0%B0%D0%B3%D0%B8%D0%BD%D0%BE%D0%B2_%D0%B2_%D0%98%D0%A3%D0%90_%D0%A1%D0%9C%D0%AD%D0%923/

Для обмена сообщениями посредством плагинов в Адаптере реализованы следующие методы REST API, доступные по адресу http://localhost:7590/plugin/{метод}:

Метод «Send», обеспечивающий отправку запросов в СМЭВ3 (Рисунок 3);

Метод «Get», обеспечивающий прием из Адаптера СМЭВ3 ответов на запросы;

Метод «Find», обеспечивающий поиск сообщений в Адаптере СМЭВ3.

Пример отправки запроса методом «Send»:

{
  "pluginMnemonic": "my-test-plugin",
  "requestContent": {
    "series": "1234",
    "number": "567890",
    "issueDate": "2020-01-01"
  }
}

Пример синхронного ответа на отправку запроса методом «Send»:

{
  "clientId": "104e9eb0-f60d-4daf-9942-29804eb05982",
  "messageId": "ff2d56af-3efe-11ed-a795-0a0027000003"
}

Пример отправки запроса на получения ответа из СМЭВ методом «Get»:

{
  "pluginMnemonic": "my-test-plugin"
  "clientId": "104e9eb0-f60d-4daf-9942-29804eb05982",
  "messageId": "ff2d56af-3efe-11ed-a795-0a0027000003"
}

Пример ответа в случае, если паспортные данные принадлежат существующему действующему паспорту:

{
  "clientId": "ad6f6e31-a861-44ad-97f4-6a73b287c135",
  "replyToClientId": "104e9eb0-f60d-4daf-9942-29804eb05982",
  "messageId": "4c565e7c-5bf6-cd89-2531-248c7048f9e6",
  "responseContent": {
    "validDoc": null
  }
}

Пример ответа в случае, если указанные паспортные данные не существуют:

{
  "clientId": "1781d3ed-5a8e-4eb1-8426-6eed78af221e",
  "replyToClientId": "104e9eb0-f60d-4daf-9942-29804eb05982",
  "messageId": "4c565e7c-5bf6-cd89-2531-248c7048f9e6",
  "responseContent": {
    "notFoundDoc": {}
  }
}

Пример ответа в случае, если указанный паспорт не действителен:

{
  "clientId": "104e9eb0-f60d-4daf-9942-29804eb05981",
  "replyToClientId": "104e9eb0-f60d-4daf-9942-29804eb05982",
  "messageId": "4c565e7c-5bf6-cd89-2531-248c7048f9e6",
  "responseContent": {
    "invalidDoc": {
      "invalidityReason": "606",
      "invalidityDate": "2007-10-26"
    }
  }
}

 */

interface Smev3Service {
    fun send(smev3Request: Smev3Request): Smev3Response
    fun get(requestId: String): PassportCheckResult
    fun find(requestId: String): Smev3Request
}

@Service
open class Smev3ServiceImpl(
) : Smev3Service {
    override fun send(smev3Request: Smev3Request): Smev3Response {
        Thread.sleep(LongRange(1000L,20000L).random())
        return Smev3Response(CLIENT_ID, UUID.randomUUID().toString())
//        TODO("Not yet implemented: http://localhost:7590/plugin/send")
    }

    override fun get(requestId: String): PassportCheckResult {
        Thread.sleep(LongRange(1000L,10000L).random())
        return PassportCheckResult(
            CLIENT_ID,
            CLIENT_ID,
            requestId,
            ResponseContent(true)
        )
//        TODO("Not yet implemented: http://localhost:7590/plugin/get")
    }

    override fun find(requestId: String): Smev3Request {
        TODO("Not yet implemented: http://localhost:7590/plugin/find")
    }

    private companion object
    val CLIENT_ID = "01995c35-68e3-751f-8318-0d7a10020b54"
}