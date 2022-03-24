package com.example.movilepayinterview.repository

import com.example.datasource.provider.ConfigurationProvider
import com.example.movilepayinterview.mapper.WidgetMapper
import com.example.movilepayinterview.model.Widget

class ConfigurationRepositoryImpl(
    private val configurationProvider: ConfigurationProvider,
    private val widgetMapper: WidgetMapper
): ConfigurationRepository {

    override suspend fun fetchHomeWidgets(): Widget {
        val widget = widgetMapper.toDomain(configurationProvider.fetchHomeWidgets())
        return widget
    }

}