package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.CardDto
import com.example.datasource.model.StatementBalanceDto
import com.example.datasource.model.StatementTransactionDto
import com.example.datasource.model.WidgetDto
import com.example.movilepayinterview.model.Card
import com.example.movilepayinterview.model.StatementBalance
import com.example.movilepayinterview.model.StatementTransaction
import com.example.movilepayinterview.model.Widget

class StatementBalanceMapper : DataMapper<StatementBalanceDto, StatementBalance>() {
    override fun toDomain(data: StatementBalanceDto) = StatementBalance(
        label = data.label,
        value = data.value
    )
}









