package com.example.movilepayinterview.mapper

import com.example.commons.mapper.DataMapper
import com.example.datasource.model.*
import com.example.movilepayinterview.model.*

class StatementMapper(
    private val balanceMapper: StatementBalanceMapper,
    private val transactionMapper: StatementTransactionMapper
) : DataMapper<StatementDto, Statement>() {
    override fun toDomain(data: StatementDto) = Statement(
        balance = balanceMapper.toDomain(data.balance),
        transactions = transactionMapper.mapList(data.transactions)
    )
}









