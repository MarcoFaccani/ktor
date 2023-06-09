package com.marcofaccani.plugins

import com.marcofaccani.services.CurrencyService
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger


fun Application.configureKoin() {

  val koinModule = module {
    single { CurrencyService() }
  }

  install(Koin) {
    slf4jLogger()
    modules(koinModule)
  }
}

