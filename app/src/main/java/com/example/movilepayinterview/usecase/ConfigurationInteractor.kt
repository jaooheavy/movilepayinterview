package com.example.movilepayinterview.usecase

import com.example.movilepayinterview.repository.ConfigurationRepository
import com.example.movilepayinterview.state.CardState
import com.example.movilepayinterview.state.StatementState
import com.example.movilepayinterview.state.WidgetState

class ConfigurationInteractor(
    private val configurationRepository: ConfigurationRepository
): ConfigurationUseCase {

    override suspend fun fetchHomeWidgets() = try {
        val widget = configurationRepository.fetchHomeWidgets()
        WidgetState.Loaded(widget)
    }catch (ex: Exception) {
        WidgetState.Error(ex.message ?: "Something went wrong")
    }

    override suspend fun fetchCard() = try {
        val card = configurationRepository.fetchCard()
        CardState.Loaded(card)
    }catch (ex: Exception) {
        CardState.Error(ex.message ?: "Something went wrong")
    }

    override suspend fun fetchStatement() = try {
        val widget = configurationRepository.fetchStatement()
        StatementState.Loaded(widget)
    }catch (ex: Exception) {
        StatementState.Error(ex.message ?: "Something went wrong")
    }

}