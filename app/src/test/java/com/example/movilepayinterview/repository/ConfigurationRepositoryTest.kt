package com.example.movilepayinterview.repository

import com.example.datasource.provider.ConfigurationProvider
import com.example.movilepayinterview.StubFactory
import com.example.movilepayinterview.mapper.*
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class ConfigurationRepositoryTest {

    private val configProvider = mockk<ConfigurationProvider>(relaxed = true)
    private val configRepository: ConfigurationRepository = ConfigurationRepositoryImpl(
        configProvider,
        StubFactory.widgetMapper,
        StubFactory.cardMapper,
        StubFactory.statementMapper
    )

    @ExperimentalCoroutinesApi
    @Test
    fun `test fetchHomeWidgets`() = runBlockingTest{
        configRepository.fetchHomeWidgets()

        coVerify {
            configProvider.fetchHomeWidgets()
        }
    }
}