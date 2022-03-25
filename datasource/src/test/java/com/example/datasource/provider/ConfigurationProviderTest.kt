package com.example.datasource.provider

import com.example.datasource.ConfigurationService
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class ConfigurationProviderTest {

    private val configurationService = mockk<ConfigurationService>(relaxed = true)
    private val configurationProvider: ConfigurationProvider = ConfigurationProviderImpl(configurationService)

    @ExperimentalCoroutinesApi
    @Test
    fun `test fetchHomeWidgets`() = runBlockingTest{
        configurationProvider.fetchHomeWidgets()

        coVerify {
            configurationService.fetchHomeWidget()
        }
    }
}