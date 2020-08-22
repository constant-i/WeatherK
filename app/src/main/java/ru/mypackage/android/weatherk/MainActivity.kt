package ru.mypackage.android.weatherk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import ru.mypackage.android.weatherk.domain.OnItemClickListener
import ru.mypackage.android.weatherk.domain.RequestForecastCommand
import ru.mypackage.android.weatherk.domain.model.ForecastModels


class MainActivity : AppCompatActivity() {

    companion object {
        val URL =
            "http://api.openweathermap.org/data/2.5/forecast?q=Moscow&units=metric&appid=29fb8d6056fe0f462c0731feda71d342"
    }

    private lateinit var forecastList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList = forecast_list
        forecastList.layoutManager = LinearLayoutManager(this)
//        forecastList.adapter = ForecastListAdapter(items)
        GetForecast(URL)
    }


    fun GetForecast(url: String) {
        async() {
            val result = RequestForecastCommand(/*"94043"*/"141240").execute()
            uiThread {
                forecastList.adapter =
                    ForecastListAdapter(result) { modelForecast -> longToast(modelForecast.date) }
            }
        }
    }
}
