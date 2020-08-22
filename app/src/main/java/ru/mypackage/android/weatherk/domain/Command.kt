package ru.mypackage.android.weatherk.domain

interface Command<T> {
    fun execute(): T
}