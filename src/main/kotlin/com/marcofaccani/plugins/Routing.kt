package com.marcofaccani.plugins

import com.marcofaccani.models.exceptions.ValidationException
import com.marcofaccani.services.CurrencyService
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

  val currencyService by inject<CurrencyService>()

  routing {

    route("/status") {
      get {
        return@get call.respondText("Status UP", status = HttpStatusCode.OK)
      }
    }

    route("/financial/currency:convert") {
      get("/{from?}/{to?}/{amount?}") {

        val from = call.parameters["from"] ?: throw ValidationException("from is missing")
        val to = call.parameters["to"] ?: throw ValidationException("to is missing")
        val amount = call.parameters["amount"] ?: throw ValidationException("amount is missing")

        val response = currencyService.convertCurrency(from, to, amount)
        return@get call.respondText(response, status = HttpStatusCode.OK, contentType = ContentType.Application.Json)
      }
    }
  }
}
