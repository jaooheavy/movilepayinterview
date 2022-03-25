package com.example.datasource.model

data class StatementDto(
    val balance: StatementBalanceDto,
    val transactions: List<StatementTransactionDto>
)
