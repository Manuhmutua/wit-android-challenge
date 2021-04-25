package com.manuh.share.witinterviewapplication.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manuh.share.witinterviewapplication.R
import com.manuh.share.witinterviewapplication.adapter.ItemAdapter
import com.manuh.share.witinterviewapplication.model.Item
import com.manuh.share.witinterviewapplication.viewmodel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitiesFragment : Fragment() {

    lateinit var viewModel: ItemViewModel
    var mAdapter: ItemAdapter? = null

    private lateinit var rvCities: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[ItemViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cities, container, false)

        rvCities = view.findViewById(R.id.rvCities)

        rvCities.adapter = mAdapter
        rvCities.layoutManager = LinearLayoutManager(context)

        val cities = arrayListOf(
            "Nairobi",
            "Lisbon",
            "Madrid",
            "Paris",
            "Berlin",
            "Copenhagen",
            "Rome",
            "London",
            "Dublin",
            "Prague",
            "Vienna"
        )

        cities.forEach {
            viewModel.getItem(
                view.context.applicationContext,
                it,
                "ef585ba9e41684caab651e25602ff670"
            )
        }

        viewModel.getItems()?.observe(this.viewLifecycleOwner) { item ->
            loadResults(item as MutableList<Item>)
        }

        return view

    }

    private fun loadResults(results: MutableList<Item>) {
        mAdapter = ItemAdapter(results)
        rvCities.adapter = mAdapter
        mAdapter?.updateData(results)
    }

}

