package com.example.datasource.model

data class StatementDto(
    val balance: StatementBalanceDto = StatementBalanceDto(),
    val transactions: List<StatementTransactionDto> = emptyList()
)
