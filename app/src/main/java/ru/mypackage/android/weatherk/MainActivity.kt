package ru.mypackage.android.weatherk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        val URL = "http://api.openweathermap.org/data/2.5/forecast?q=Moscow&units=metric&appid=29fb8d6056fe0f462c0731feda71d342"
    }

//    private val items = listOf(
//        "Mon 6/23 - Sunny - 31/17",
//        "Tue 6/24 - Foggy - 21/8",
//        "Wed 6/25 - Cloudy - 22/17",
//        "Thurs 6/26 - Rainy - 18/11",
//        "Fri 6/27 - Foggy - 21/10",
//        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
//        "Sun 6/29 - Sunny - 20/7"
//    )

    private lateinit var forecastList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList = forecast_list
        forecastList.layoutManager = LinearLayoutManager(this)
//        forecastList.adapter = ForecastListAdapter(items)

        someAction(URL)
    }



    fun someAction (url : String) {
        async() {
            val result = RequestForecastCommand(/*"94043"*/"141240").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result,
                object : OnItemClickListener {
                    override fun invoke(forecast: ForecastModels.ModelForecast) {
                        longToast(forecast.date)
                    }
                })
                longToast("Request performed")
            }
        }
    }

    fun niceToast(message: String, tag: String = MainActivity::class.java.simpleName, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "[$tag] $message", length).show()
    }
}
