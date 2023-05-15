package com.marcofaccani.service

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

class InboundValidator {

  suspend fun getRequiredParameter(call: ApplicationCall, paramName: String): String? {
    val paramValue = call.parameters[paramName]
    if (paramValue.isNullOrEmpty()) {
      call.respondText(
        "Missing required parameter: $paramName",
        status = HttpStatusCode.BadRequest
      )
      return null
    }
    return paramValue
  }

}