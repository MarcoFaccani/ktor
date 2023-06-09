package com.marcofaccani.plugins

import com.marcofaccani.models.exceptions.ValidationException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureExceptions() {

  install(StatusPages) {

    exception<Throwable> { call, throwable ->
      when(throwable) {
        is ValidationException -> {
          call.respond(
            HttpStatusCode.BadRequest,
            "Validation error: ${throwable.message}"
          )
        }
        is Exception -> {
          call.respond(
            HttpStatusCode.InternalServerError,
            "Unknown error: ${throwable.message}"
          )
        }
      }
    }

  }
}