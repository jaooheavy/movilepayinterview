package com.example.datasource.provider

import com.example.datasource.model.CardDto
import com.example.datasource.model.StatementDto
import com.example.datasource.model.WidgetDto

interface ConfigurationProvider {
    suspend fun fetchHomeWidgets(): WidgetDto

    suspend fun fetchCard(): CardDto

    suspend fun fetchStatement(): StatementDto
}