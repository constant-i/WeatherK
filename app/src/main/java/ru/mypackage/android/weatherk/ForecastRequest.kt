package ru.mypackage.android.weatherk

import android.util.Log
import com.google.gson.Gson
import ru.mypackage.android.weatherk.data.model.ResponseClasses.ForecastResult
import java.net.URL

class ForecastRequest(val zipCode: String) {
    companion object {
        val MyTAG = "MyTAG"
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=30"           // todo тут задаю кол-во дней
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d(MyTAG, forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}