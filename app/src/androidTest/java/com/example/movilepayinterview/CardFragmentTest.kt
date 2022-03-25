package com.example.movilepayinterview

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardFragmentTest: BaseTest(){

    @Test
    fun validateAllTextsDisplayedWithTexts() {
        launchFragmentInContainer<CardScreenFragment>()

        onView(withId(R.id.tvCardNumber))
            .check(matches(withText("cardNumber")))
        onView(withId(R.id.tvCardName))
            .check(matches(withText("cardName")))
        onView(withId(R.id.tvExpiration))
            .check(matches(withText("Expiration: expirationDate")))
        onView(withId(R.id.tvLimit))
            .check(matches(withText("Limite disponivel: availableLimit")))
        onView(withId(R.id.tvLimit2))
            .check(matches(withText("Limite Total: totalLimit")))
    }
}