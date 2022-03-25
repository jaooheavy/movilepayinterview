package com.example.movilepayinterview.repository

import com.example.datasource.provider.ConfigurationProvider
import com.example.movilepayinterview.mapper.CardMapper
import com.example.movilepayinterview.mapper.StatementMapper
import com.example.movilepayinterview.mapper.WidgetMapper
import com.example.movilepayinterview.model.Card
import com.example.movilepayinterview.model.Statement
import com.example.movilepayinterview.model.Widget

class ConfigurationRepositoryImpl(
    private val configurationProvider: ConfigurationProvider,
    private val widgetMapper: WidgetMapper,
    private val cardMapper: CardMapper,
    private val statementMapper: StatementMapper
): ConfigurationRepository {

    override suspend fun fetchHomeWidgets(): Widget {
        val widget = widgetMapper.toDomain(configurationProvider.fetchHomeWidgets())
        return widget
    }

    override suspend fun fetchCard(): Card {
        val card = cardMapper.toDomain(configurationProvider.fetchCard())
        return card
    }

    override suspend fun fetchStatement(): Statement {
        val statement = statementMapper.toDomain(configurationProvider.fetchStatement())
        return statement
    }

}