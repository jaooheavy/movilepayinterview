package com.example.datasource

import com.example.datasource.model.CardDto
import com.example.datasource.model.StatementDto
import com.example.datasource.model.StatementTransactionDto
import com.example.datasource.model.WidgetDto
import retrofit2.http.GET

interface ConfigurationService {
    @GET("home")
    suspend fun fetchHomeWidget(): WidgetDto

    @GET("card/123")
    suspend fun fetchCard(): CardDto

    @GET("statement/123")
    suspend fun fetchStatement(): StatementDto
}