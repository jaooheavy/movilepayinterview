package com.example.datasource.provider

import com.example.datasource.ConfigurationService
import com.example.datasource.model.WidgetDto

class ConfigurationProviderImpl(
    private val configurationService: ConfigurationService
): ConfigurationProvider {
    override suspend fun fetchHomeWidgets(): WidgetDto {
        return configurationService.fetchHomeWidget()
    }
}