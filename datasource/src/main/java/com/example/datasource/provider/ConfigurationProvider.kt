package com.example.datasource.provider

import com.example.datasource.model.WidgetDto

interface ConfigurationProvider {
    suspend fun fetchHomeWidgets(): WidgetDto
}