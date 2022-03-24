package com.example.movilepayinterview.usecase

import com.example.movilepayinterview.state.WidgetState

interface ConfigurationUseCase {

    suspend fun fetchHomeWidgets(): WidgetState
}