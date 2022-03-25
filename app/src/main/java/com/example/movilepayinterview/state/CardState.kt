package com.example.movilepayinterview.state

import com.example.movilepayinterview.model.Card

sealed class CardState {
    object Empty: CardState()
    object Loading: CardState()
    data class Loaded(
        val card: Card
    ): CardState()
    data class Error(
        val errorMessage: String
    ): CardState()
}
