package com.example.movilepayinterview.core

import androidx.navigation.NavController
import com.example.datasource.core.DatasourceDI
import com.example.movilepayinterview.mapper.*
import com.example.movilepayinterview.repository.ConfigurationRepository
import com.example.movilepayinterview.repository.ConfigurationRepositoryImpl
import com.example.movilepayinterview.usecase.ConfigurationInteractor
import com.example.movilepayinterview.usecase.ConfigurationUseCase
import com.example.movilepayinterview.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinDI {

    val viewModels = module {
        viewModel { HomeViewModel(get()) }
    }

    val usecases = module {
        factory<ConfigurationRepository> { ConfigurationRepositoryImpl(get(), get()) }
    }

    val repositories = module {
        factory<ConfigurationUseCase> { ConfigurationInteractor(get()) }
    }

    val mappers = module {
        factory { WidgetMapper(get()) }
        factory { WidgetItemMapper(get()) }
        factory { WidgetItemContentMapper(get(), get()) }
        factory { WidgetItemContentButtonMapper(get()) }
        factory { WidgetItemContentBalanceMapper() }
        factory { WidgetItemContentButtonActionMapper(get()) }
        factory { WidgetItemContentButtonActionContentMapper() }
    }

    val app = module {
        factory<MovileActions> { (navController: NavController) ->
            MovileActionsImpl(navController = navController)
        }
    }

    val modules = DatasourceDI.modules + viewModels + usecases + repositories + mappers + app
}