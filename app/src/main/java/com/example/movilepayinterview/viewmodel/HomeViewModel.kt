package com.example.movilepayinterview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.movilepayinterview.state.WidgetState
import com.example.movilepayinterview.usecase.ConfigurationUseCase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val configurationUseCase: ConfigurationUseCase
): ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.Main

    override fun onCleared() {
        widgetState.removeObserver(observer)
        cancel()
        super.onCleared()
    }

    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData(false)
    val loadingState: LiveData<Boolean> = _loadingState

    private val _widgetState: MutableLiveData<WidgetState> = MutableLiveData(WidgetState.Empty)
    val widgetState: LiveData<WidgetState> = _widgetState

    private val observer: Observer<Any> = Observer {
        val widget = widgetState.value
        _loadingState.postValue(
            when(widget){
                is WidgetState.Loading -> true
                else -> false
            }
        )
    }

    fun fetchData(){
        widgetState.observeForever(observer)
        launch {
            updateHomeState(WidgetState.Loading)

            val result = withContext(Dispatchers.IO) { configurationUseCase.fetchHomeWidgets() }

            updateHomeState(result)
        }
    }

    private fun updateHomeState(widgetState: WidgetState) = _widgetState.postValue(widgetState)
}