package com.marcofaccani.plugins

import com.marcofaccani.service.CurrencyService
import com.marcofaccani.service.InboundValidator
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

  val inboundValidator by inject<InboundValidator>()
  val currencyService by inject<CurrencyService>()

  routing {

    route("/status") {
      get {
        return@get call.respondText("Status UP", status = HttpStatusCode.OK)
      }
    }

    route("/financial/currency:convert") {
      get("/{from?}/{to?}/{amount?}") {

        val from = inboundValidator.getRequiredParameter(call, "from")
        val to = inboundValidator.getRequiredParameter(call, "to")
        val amount = inboundValidator.getRequiredParameter(call, "amount")

        val response = currencyService.convertCurrency(from, to, amount)
        return@get call.respondText(response, status = HttpStatusCode.OK, contentType = ContentType.Application.Json)
      }
    }
  }
}
