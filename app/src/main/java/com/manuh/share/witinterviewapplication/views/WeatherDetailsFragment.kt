package com.manuh.share.witinterviewapplication.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.manuh.share.witinterviewapplication.R
import com.manuh.share.witinterviewapplication.model.Item
import com.manuh.share.witinterviewapplication.model.Main
import com.manuh.share.witinterviewapplication.model.Weather
import com.manuh.share.witinterviewapplication.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.text.Typography.degree


@AndroidEntryPoint
class WeatherDetailsFragment : Fragment() {

    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[ItemViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weather_details, container, false)
//        Toast.makeText(context?.applicationContext, arguments?.getString("id"), Toast.LENGTH_LONG)
//            .show()

        val temperature = view.findViewById<TextView>(R.id.temperature)
        val cityName = view.findViewById<TextView>(R.id.cityName)
        val weatherMain = view.findViewById<TextView>(R.id.weatherMain)
        val weatherIcon = view.findViewById<ImageView>(R.id.weatherIcon)
        val minTemp = view.findViewById<TextView>(R.id.minTemp)
        val maxTemp = view.findViewById<TextView>(R.id.maxTemp)
        val pressure = view.findViewById<TextView>(R.id.pressure)
        val humidity = view.findViewById<TextView>(R.id.humidity)
        val feelsLike = view.findViewById<TextView>(R.id.feelsLike)
        val weatherDescription = view.findViewById<TextView>(R.id.weatherDescription)

        viewModel.getItem(arguments?.getString("item_id")!!.toInt())
            ?.observe(this.viewLifecycleOwner) { item ->
                cityName.text = item!!.name
            }

        viewModel.getMainItem(arguments?.getString("item_id")!!.toInt())
            ?.observe(this.viewLifecycleOwner) { item ->

                temperature.text =
                    (String.format("%.1f",item?.temp?.minus(273.15))).toString() + "" + degree
                humidity.text = "Humidity: " + item?.humidity.toString() + "%"
                pressure.text = "Pressure: " + (String.format("%.3f",item?.pressure?.div(1000))) + "kPa"
                maxTemp.text =
                    "Maximum Temp: " + (String.format("%.3f",item?.temp_max?.minus(273.15))) + "" + degree
                minTemp.text =
                    "Minimum Temp: " + (String.format("%.3f",item?.temp_min?.minus(273.15))) + "" + degree
                feelsLike.text =
                    "Feels Like: " + (String.format("%.3f",item?.feels_like?.minus(273.15))) + "" + degree

            }

        viewModel.getWeatherItem(arguments?.getString("item_id")!!.toInt())
            ?.observe(this.viewLifecycleOwner) { item ->

                weatherMain.text = item?.main
                Glide.with(requireContext().applicationContext).load(
                    "http://openweathermap.org/img/w/" + item?.icon + ".png"
                ).into(weatherIcon)
                weatherDescription.text =
                    item?.description
            }

        return view
    }

}