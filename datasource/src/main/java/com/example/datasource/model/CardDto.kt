package com.example.datasource.model

data class CardDto(
    val cardNumber: String = "",
    val cardName: String = "",
    val expirationDate: String = "",
    val availableLimit: String = "",
    val totalLimit: String = ""
)
