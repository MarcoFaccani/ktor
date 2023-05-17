package com.marcofaccani.services

import com.marcofaccani.models.exceptions.ValidationException
import io.ktor.server.application.*

class InboundValidator {

  fun getRequiredParameter(call: ApplicationCall, paramName: String): String {
    val paramValue = call.parameters[paramName]
    if (paramValue.isNullOrEmpty()) {
      throw ValidationException("Missing required parameter: $paramName")
    }
    return paramValue
  }

}