package ru.mypackage.android.weatherk

import android.util.Log
import java.net.URL

class Request(val url: String) {

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }

//    companion object {
//        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
//        private val URL = "http://api.openweathermap.org/data/2.5/" +
//                "forecast/daily?mode=json&units=metric&cnt=7"
//        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
//    }
//
//    fun run(): ResponseClasses.ForecastResult {
//        val forecastJsonStr = URL(COMPLETE_URL + /*zipCode*/"141200").readText()
//        Log.d(javaClass.simpleName, forecastJsonStr)
//        return Gson().fromJson(forecastJsonStr, ResponseClasses.ForecastResult::class.java)
//    }

}