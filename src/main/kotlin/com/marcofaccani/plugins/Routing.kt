package com.marcofaccani.plugins

import com.marcofaccani.service.InboundValidator
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

  val inboundValidator by inject<InboundValidator>()

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

        return@get call.respondText("Success", status = HttpStatusCode.OK)
      }
    }
  }
}
