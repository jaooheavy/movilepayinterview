package com.example.movilepayinterview.repository

import com.example.movilepayinterview.model.Widget

interface ConfigurationRepository {

    suspend fun fetchHomeWidgets(): Widget
}