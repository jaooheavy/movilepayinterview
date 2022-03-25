package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.CardDto
import com.example.datasource.model.StatementTransactionDto
import com.example.datasource.model.WidgetDto
import com.example.movilepayinterview.model.Card
import com.example.movilepayinterview.model.StatementTransaction
import com.example.movilepayinterview.model.Widget

class StatementTransactionMapper : DataMapper<StatementTransactionDto, StatementTransaction>() {
    override fun toDomain(data: StatementTransactionDto) = StatementTransaction(
        label = data.label,
        value = data.value,
        description = data.description
    )
}









