package com.marcofaccani.plugins

import com.marcofaccani.service.CurrencyService
import com.marcofaccani.service.InboundValidator
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger


fun Application.configureKoin() {

  val koinModule = module {
    single { InboundValidator() }
    single { CurrencyService() }
  }

  install(Koin) {
    slf4jLogger()
    modules(koinModule)
  }
}

