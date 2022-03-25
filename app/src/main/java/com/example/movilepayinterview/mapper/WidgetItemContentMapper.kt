package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.WidgetItemContentDto
import com.example.movilepayinterview.model.WidgetItemContent

class WidgetItemContentMapper(
    private val balanceMapper: WidgetItemContentBalanceMapper,
    private val buttonMapper: WidgetItemContentButtonMapper
): DataMapper<WidgetItemContentDto, WidgetItemContent>() {
    override fun toDomain(data: WidgetItemContentDto) = WidgetItemContent(
        title = data.title,
        button = buttonMapper.toDomain(data.button),
        balance = balanceMapper.toDomain(data.balance),
        cardNumber = data.cardNumber
    )
}