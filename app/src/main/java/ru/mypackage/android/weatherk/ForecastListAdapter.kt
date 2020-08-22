package ru.mypackage.android.weatherk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import ru.mypackage.android.weatherk.domain.model.ForecastModels.*

class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (ModelForecast) -> Unit) :
    RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View, val itemClick: (ModelForecast) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.icon
            dateView = view.date
            descriptionView = view.description
            maxTemperatureView = view.maxTemperature
            minTemperatureView = view.minTemperature
        }

        fun bindForecast(forecast: ModelForecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl)
                    .into(iconView) // TODO для старой версии Picasso 2.5.2
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = high.toString()
                minTemperatureView.text = low.toString()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}