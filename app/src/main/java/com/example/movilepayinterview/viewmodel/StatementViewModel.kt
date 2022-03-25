package com.example.movilepayinterview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.movilepayinterview.state.CardState
import com.example.movilepayinterview.state.StatementState
import com.example.movilepayinterview.usecase.ConfigurationUseCase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class StatementViewModel(
    private val configurationUseCase: ConfigurationUseCase
): ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.Main

    override fun onCleared() {
        statementState.removeObserver(observer)
        cancel()
        super.onCleared()
    }

    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData(false)
    val loadingState: LiveData<Boolean> = _loadingState

    private val _statementState: MutableLiveData<StatementState> = MutableLiveData(StatementState.Empty)
    val statementState: LiveData<StatementState> = _statementState

    private val observer: Observer<Any> = Observer {
        val widget = statementState.value
        _loadingState.postValue(
            when(widget){
                is StatementState.Loading -> true
                else -> false
            }
        )
    }

    fun fetchData(){
        statementState.observeForever(observer)
        launch {
            updateStatementState(StatementState.Loading)

            val result = withContext(Dispatchers.IO) { configurationUseCase.fetchStatement() }

            updateStatementState(result)
        }
    }

    private fun updateStatementState(statementState: StatementState) = _statementState.postValue(statementState)
}