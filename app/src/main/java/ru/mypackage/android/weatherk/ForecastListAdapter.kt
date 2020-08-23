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

        fun bindForecast(forecast: ModelForecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl)
                    .into(itemView.icon) // TODO для старой версии Picasso 2.5.2
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high °C"
                itemView.minTemperature.text = "$low °C"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}