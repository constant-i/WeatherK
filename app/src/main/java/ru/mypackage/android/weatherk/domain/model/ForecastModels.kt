package ru.mypackage.android.weatherk.domain.model

class ForecastModels {
    data class ForecastList(
        val city: String,
        val country: String,
        val dailyForecast: List<ModelForecast>
    ) {
        operator fun get(position: Int) = dailyForecast[position]
        fun size() = dailyForecast.size
    }

    data class ModelForecast(
        val date: String,
        val description: String,
        val high: Int,
        val low: Int,
        val iconUrl: String
    )
}