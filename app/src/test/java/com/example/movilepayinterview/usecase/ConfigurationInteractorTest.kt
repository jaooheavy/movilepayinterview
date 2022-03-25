package com.example.movilepayinterview.usecase

import com.example.movilepayinterview.model.Widget
import com.example.movilepayinterview.repository.ConfigurationRepository
import com.example.movilepayinterview.state.WidgetState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test

class ConfigurationInteractorTest {

    private val configRepository = mockk<ConfigurationRepository>(relaxed = true)
    private val configInteractor: ConfigurationUseCase = ConfigurationInteractor(configRepository)

    @ExperimentalCoroutinesApi
    @Test
    fun `test fetchHomeWidgets success`() = runBlockingTest{
        coEvery {
            configRepository.fetchHomeWidgets()
        } answers {
            Widget(emptyList())
        }

        val result = configInteractor.fetchHomeWidgets()

        coVerify {
            configRepository.fetchHomeWidgets()
        }

        Assert.assertEquals(WidgetState.Loaded(Widget(emptyList())), result)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test fetchHomeWidgets failure`() = runBlockingTest{
        coEvery {
            configRepository.fetchHomeWidgets()
        } throws RuntimeException()

        val result = configInteractor.fetchHomeWidgets()

        coVerify {
            configRepository.fetchHomeWidgets()
        }

        Assert.assertEquals(WidgetState.Error("Something went wrong"), result)
    }
}