package com.example.counterapp_mvvm_practice

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    private val _repository = CounterRepository()

    private val _count = mutableIntStateOf(_repository.getCounter())
    val count: MutableState<Int> = _count

    fun increment(){
        _repository.incrementCounter()
        _count.intValue = _repository.getCounter()
    }
    fun decrement(){
        _repository.decrementCounter()
        _count.intValue = _repository.getCounter()

    }
}