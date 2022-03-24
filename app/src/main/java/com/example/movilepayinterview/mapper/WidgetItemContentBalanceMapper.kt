package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.WidgetItemContentBalanceDto
import com.example.movilepayinterview.model.WidgetItemContentBalance

class WidgetItemContentBalanceMapper: DataMapper<WidgetItemContentBalanceDto, WidgetItemContentBalance>() {
    override fun toDomain(data: WidgetItemContentBalanceDto) = WidgetItemContentBalance(
        label = data.label,
        value = data.value
    )
}