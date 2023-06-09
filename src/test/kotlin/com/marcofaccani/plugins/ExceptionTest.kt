package com.marcofaccani.plugins

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*

class ExceptionTest: StringSpec() {

  init {

    "should respond with BadRequest when ValidationException is thrown" {
      testApplication {
        application { configureExceptions() }

        client.get("/status").apply {
          status shouldBe HttpStatusCode.OK
          bodyAsText() shouldBe "Status UP"
        }
      }
    }

  }

}
