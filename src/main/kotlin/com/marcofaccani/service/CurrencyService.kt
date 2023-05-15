package com.marcofaccani.service

import com.example.models.GetCurrenciesResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

class CurrencyService(
) {

   fun convertCurrency(from: String, to:String, amount: String) {

      /*
      // create client
      val client = HttpClient(CIO) {
         expectSuccess = true
      }

      // Get valid currencies for validation
      val httpResponseGetCurrencies: HttpResponse = client.get("https://api.apilayer.com/exchangerates_data/symbols") {
         headers {
            append("apikey", "6Qi5cX2HdNlJZ6da39RB49B0LyaUb0Q7")
         }
      }
      val getCurrenciesResponse = jacksonObjectMapper().readValue(httpResponseGetCurrencies.bodyAsText(), GetCurrenciesResponse::class.java)

      // Validate input currencies with valid currencies from API call
      if (!getCurrenciesResponse.symbols.containsKey(from)) {
         return@get call.respondText(
            "Currency type $from is not valid",
            status = HttpStatusCode.BadRequest
         )
      }

      if (!getCurrenciesResponse.symbols.containsKey(to)) {
         return@get call.respondText(
            "Currency type $to is not valid",
            status = HttpStatusCode.BadRequest
         )
      }

      // Get valid currencies for validation
      val response: HttpResponse = client.get("https://api.apilayer.com/exchangerates_data/symbols") {
         headers {
            append("apikey", "6Qi5cX2HdNlJZ6da39RB49B0LyaUb0Q7")
         }
      }

      // Get valid currencies for validation
      val httpResponseConvertCurrency: HttpResponse = client.get("https://api.apilayer.com/exchangerates_data/convert") {
         url {
            parameters.append("from", from)
            parameters.append("to", to)
            parameters.append("amount", amount)
         }
         headers {
            append("apikey", "6Qi5cX2HdNlJZ6da39RB49B0LyaUb0Q7")
         }
      }
   }

       */
   }

}