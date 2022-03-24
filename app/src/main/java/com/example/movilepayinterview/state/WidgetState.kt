package com.example.movilepayinterview.state

import com.example.movilepayinterview.model.Widget

sealed class WidgetState {
    object Empty: WidgetState()
    object Loading: WidgetState()
    data class Loaded(
        val widgets: Widget
    ): WidgetState()
    data class Error(
        val errorMessage: String
    ): WidgetState()
}
