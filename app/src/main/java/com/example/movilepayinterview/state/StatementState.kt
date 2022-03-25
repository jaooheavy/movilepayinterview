package com.example.movilepayinterview.state

import com.example.movilepayinterview.model.Statement
import com.example.movilepayinterview.model.Widget

sealed class StatementState {
    object Empty: StatementState()
    object Loading: StatementState()
    data class Loaded(
        val statement: Statement
    ): StatementState()
    data class Error(
        val errorMessage: String
    ): StatementState()
}
