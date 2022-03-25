package com.example.datasource.provider

import com.example.datasource.ConfigurationService
import com.example.datasource.model.CardDto
import com.example.datasource.model.StatementDto
import com.example.datasource.model.WidgetDto

class ConfigurationProviderImpl(
    private val configurationService: ConfigurationService
): ConfigurationProvider {
    override suspend fun fetchHomeWidgets(): WidgetDto {
        return configurationService.fetchHomeWidget()
    }

    override suspend fun fetchCard(): CardDto {
        return configurationService.fetchCard()
    }

    override suspend fun fetchStatement(): StatementDto {
        return configurationService.fetchStatement()
    }
}