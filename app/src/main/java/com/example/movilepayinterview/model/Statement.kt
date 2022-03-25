package com.example.movilepayinterview.model

data class Statement(
    val balance: StatementBalance,
    val transactions: List<StatementTransaction>
)
