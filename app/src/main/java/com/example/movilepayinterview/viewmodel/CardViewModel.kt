package com.example.movilepayinterview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.movilepayinterview.state.CardState
import com.example.movilepayinterview.usecase.ConfigurationUseCase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CardViewModel(
    private val configurationUseCase: ConfigurationUseCase
): ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.Main

    override fun onCleared() {
        cardState.removeObserver(observer)
        cancel()
        super.onCleared()
    }

    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData(false)
    val loadingState: LiveData<Boolean> = _loadingState

    private val _cardState: MutableLiveData<CardState> = MutableLiveData(CardState.Empty)
    val cardState: LiveData<CardState> = _cardState

    private val observer: Observer<Any> = Observer {
        val widget = cardState.value
        _loadingState.postValue(
            when(widget){
                is CardState.Loading -> true
                else -> false
            }
        )
    }

    fun fetchData(){
        cardState.observeForever(observer)
        launch {
            updateCardState(CardState.Loading)

            val result = withContext(Dispatchers.IO) { configurationUseCase.fetchCard() }

            updateCardState(result)
        }
    }

    private fun updateCardState(widgetState: CardState) = _cardState.postValue(widgetState)
}