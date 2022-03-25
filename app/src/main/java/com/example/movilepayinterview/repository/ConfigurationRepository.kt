package com.example.movilepayinterview.repository

import com.example.movilepayinterview.model.Card
import com.example.movilepayinterview.model.Statement
import com.example.movilepayinterview.model.Widget

interface ConfigurationRepository {
    suspend fun fetchHomeWidgets(): Widget

    suspend fun fetchCard(): Card

    suspend fun fetchStatement(): Statement
}