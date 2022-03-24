package com.example.datasource

import com.example.datasource.model.WidgetDto
import retrofit2.http.GET

interface ConfigurationService {
    @GET("home")
    suspend fun fetchHomeWidget(): WidgetDto
}