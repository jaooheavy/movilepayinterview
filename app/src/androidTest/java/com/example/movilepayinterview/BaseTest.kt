package com.example.movilepayinterview

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movilepayinterview.model.Card
import com.example.movilepayinterview.state.CardState
import com.example.movilepayinterview.usecase.ConfigurationUseCase
import com.example.movilepayinterview.viewmodel.CardViewModel
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
abstract class BaseTest {
    val configurationUseCase = mockk<ConfigurationUseCase>(relaxed = true) {
        coEvery { fetchCard() } answers {
            CardState.Loaded(
                card = Card(
                    cardNumber  = "cardNumber",
                    cardName = "cardName",
                    expirationDate = "expirationDate",
                    availableLimit = "availableLimit",
                    totalLimit  = "totalLimit"
                )
            )
        }
    }

    val module = module {
        factory { configurationUseCase }

        viewModel { CardViewModel(get()) }
    }

    @Before
    fun init() {
        loadKoinModules(module)
    }

    @After
    fun finish() {
        unloadKoinModules(module)
    }
}