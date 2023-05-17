package com.marcofaccani.services

import com.marcofaccani.models.GetCurrenciesResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json


class CurrencyService {

  fun convertCurrency(from: String, to: String, amount: String): String {

    var conversionResponse: String
    // CIO Http Client is an async client. If we intend to use it sync, we need a runBlocking block (my intuition)
    runBlocking {

      val client = HttpClient(CIO) {
        install(ContentNegotiation) {
          json(Json {
            prettyPrint = true
            isLenient = true
          })
        }
      }

      val response: HttpResponse = client.get("https://api.apilayer.com/exchangerates_data/symbols") {
        contentType(ContentType.Application.Json)
        headers {
          append("apikey", "6Qi5cX2HdNlJZ6da39RB49B0LyaUb0Q7")
        }
        // if we required to send a body for POST or such, we could have used setBody(Customer(3, "Jet", "Brains"))
      }
      println(response.bodyAsText())

      val getCurrenciesResponse: GetCurrenciesResponse = response.body()

      if (!getCurrenciesResponse.symbols.containsKey(from)) {

        /* TODO: I dont have a reference to call object here
        return@get call.respond(
          "Currency type $from is not valid",
          status = HttpStatusCode.BadRequest
        )

       if (!getCurrenciesResponse.symbols.containsKey(to)) {
        return@get call.respondText(
          "Currency type $to is not valid",
          status = HttpStatusCode.BadRequest
        )
        } */
      }

      val httpResponseConvertCurrency = client.get("https://api.apilayer.com/exchangerates_data/convert") {
        contentType(ContentType.Application.Json)
        url {
          parameters.append("from", from)
          parameters.append("to", to)
          parameters.append("amount", amount)
        }
        headers {
          append("apikey", "6Qi5cX2HdNlJZ6da39RB49B0LyaUb0Q7")
        }
      }

      conversionResponse =  httpResponseConvertCurrency.bodyAsText()
    }
    return conversionResponse
  }

}