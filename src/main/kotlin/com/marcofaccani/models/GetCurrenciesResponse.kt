package com.marcofaccani.models

import kotlinx.serialization.Serializable

@Serializable
data class GetCurrenciesResponse(
  val success: Boolean,
  val symbols: Map<String, String>
)