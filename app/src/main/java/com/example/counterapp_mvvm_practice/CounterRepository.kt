package com.example.counterapp_mvvm_practice

class CounterRepository {
    private var counter = CounterModel(0)

    fun getCounter() = counter.count

    fun incrementCounter(){
        counter.count++
    }

    fun decrementCounter(){
        counter.count--
    }
}