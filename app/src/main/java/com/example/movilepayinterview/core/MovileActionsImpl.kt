package com.example.movilepayinterview.core

import androidx.navigation.NavController
import com.example.movilepayinterview.HomeScreenFragmentDirections

class MovileActionsImpl(
    private val navController: NavController
): MovileActions {

    override fun orchestratorActionFromWidget(identification: String) {
        when(identification) {
            "CARD_SCREEN" -> goFromHomeScreenToCardScreen()
            "STATEMENT_SCREEN" -> goFromHomeScreenToStatementScreen()
        }
    }

    private fun goFromHomeScreenToCardScreen() {
        navController.navigate(HomeScreenFragmentDirections.homeScreenTocardScreenFragment())
    }

    private fun goFromHomeScreenToStatementScreen() {
        navController.navigate(HomeScreenFragmentDirections.homeScreenTostatementScreenFragment())
    }
}