package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.CardDto
import com.example.datasource.model.WidgetDto
import com.example.movilepayinterview.model.Card
import com.example.movilepayinterview.model.Widget

class CardMapper : DataMapper<CardDto, Card>() {
    override fun toDomain(data: CardDto) = Card(
        cardNumber = data.cardNumber,
        cardName = data.cardName,
        expirationDate = data.expirationDate,
        availableLimit = data.availableLimit,
        totalLimit = data.totalLimit
    )
}









