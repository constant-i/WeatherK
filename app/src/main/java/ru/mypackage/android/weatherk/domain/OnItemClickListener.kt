package ru.mypackage.android.weatherk.domain

import ru.mypackage.android.weatherk.data.model.ResponseClasses
import ru.mypackage.android.weatherk.domain.model.ForecastModels

interface OnItemClickListener {
//    operator fun invoke(forecast: ResponseClasses.Forecast)
    operator fun invoke(forecast: ForecastModels.ModelForecast)
}