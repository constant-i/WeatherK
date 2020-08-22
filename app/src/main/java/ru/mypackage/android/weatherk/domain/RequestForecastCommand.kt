package ru.mypackage.android.weatherk.domain

import ru.mypackage.android.weatherk.ForecastRequest
import ru.mypackage.android.weatherk.domain.model.ForecastModels.*

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}