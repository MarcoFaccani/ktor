package com.example.models

data class GetCurrenciesResponse(
  val success: Boolean,
  val symbols: Map<String, String>
)