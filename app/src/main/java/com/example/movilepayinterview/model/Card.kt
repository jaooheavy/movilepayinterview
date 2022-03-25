package com.example.movilepayinterview.model

data class Card(
    val cardNumber: String,
    val cardName: String,
    val expirationDate: String,
    val availableLimit: String,
    val totalLimit: String
)
