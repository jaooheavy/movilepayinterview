package com.example.movilepayinterview.mapper

import com.example.datasource.model.CardDto
import org.junit.Assert
import org.junit.Test

class CartMapperTest {

    private val mapper = CardMapper()

    @Test
    fun `test CardMapper`() {
        val dto = CardDto(
            cardNumber = "number",
            cardName = "cardName",
            expirationDate = "expirationDate",
            availableLimit = "availableLimit",
            totalLimit = "totalLimit"
        )

        val result = mapper.toDomain(dto)

        Assert.assertEquals(dto.cardNumber, result.cardNumber)
        Assert.assertEquals(dto.cardName, result.cardName)
        Assert.assertEquals(dto.expirationDate, result.expirationDate)
        Assert.assertEquals(dto.availableLimit, result.availableLimit)
        Assert.assertEquals(dto.totalLimit, result.totalLimit)
    }
}