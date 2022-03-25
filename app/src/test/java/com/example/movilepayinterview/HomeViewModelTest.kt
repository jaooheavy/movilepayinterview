package com.example.movilepayinterview

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movilepayinterview.core.TestCoroutineRule
import com.example.movilepayinterview.model.Widget
import com.example.movilepayinterview.state.WidgetState
import com.example.movilepayinterview.usecase.ConfigurationUseCase
import com.example.movilepayinterview.viewmodel.HomeViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule: TestRule = TestCoroutineRule()

    private val configurationUseCase = mockk<ConfigurationUseCase>(relaxed = true)
    private val viewModel = HomeViewModel(configurationUseCase)

    @Test
    fun `test fetchData() success`() = runBlockingTest {
        // GIVEN
        val expectedResult = WidgetState.Loaded(Widget(emptyList()))
        coEvery {
            configurationUseCase.fetchHomeWidgets()
        } answers {
            expectedResult
        }

        // WHEN
        viewModel.fetchData()

        coVerify {
            configurationUseCase.fetchHomeWidgets()
        }

        // THEN
        Assert.assertEquals(expectedResult, viewModel.widgetState.value)
    }

    @Test
    fun `test fetchData() failure`() = runBlockingTest {
        // GIVEN
        val expectedResult = WidgetState.Error("")
        coEvery {
            configurationUseCase.fetchHomeWidgets()
        } answers {
            expectedResult
        }

        // WHEN
        viewModel.fetchData()

        coVerify {
            configurationUseCase.fetchHomeWidgets()
        }

        // THEN
        Assert.assertEquals(expectedResult, viewModel.widgetState.value)
    }

}