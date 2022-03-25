package com.example.movilepayinterview.usecase

import com.example.movilepayinterview.state.CardState
import com.example.movilepayinterview.state.StatementState
import com.example.movilepayinterview.state.WidgetState

interface ConfigurationUseCase {

    suspend fun fetchHomeWidgets(): WidgetState

    suspend fun fetchCard(): CardState

    suspend fun fetchStatement(): StatementState
}