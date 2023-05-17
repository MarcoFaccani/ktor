package com.marcofaccani.plugins

import com.marcofaccani.models.exceptions.ValidationException
import com.marcofaccani.services.CurrencyService
import com.marcofaccani.services.InboundValidator
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import io.ktor.http.*
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

class RoutingTest : StringSpec(), KoinTest {

  private val inboundValidator: InboundValidator by inject()
  private val currencyService: CurrencyService by inject()

  init {

    // Configure Koin Dependency Injection for Testing
    val testModule = module {
      single { CurrencyService() }
      single { InboundValidator() }
    }

    beforeTest {
      startKoin {
        modules(testModule)
      }
    }

    afterTest {
      stopKoin()
    }

    "test status" {
      testApplication {
        application { configureRouting() }

        client.get("/status").apply {
          status shouldBe HttpStatusCode.OK
          bodyAsText() shouldBe "Status UP"
        }

      }
    }

    "convert currency - should return 400 Bad Request" {
      testApplication {
        application {
          configureRouting()
          configureExceptions()
        }

        every { inboundValidator.getRequiredParameter(any(), any()) } throws ValidationException("error")

        client.get("/financial/currency:convert").apply {
          status shouldBe HttpStatusCode.BadRequest
        }
      }
    }

  }

}