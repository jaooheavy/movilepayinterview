package com.example.movilepayinterview.usecase

import com.example.movilepayinterview.repository.ConfigurationRepository
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

}