package com.manuh.share.witinterviewapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.manuh.share.witinterviewapplication.R
import com.manuh.share.witinterviewapplication.model.Item

class ItemAdapter(
    var mList: MutableList<Item>
) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var city = itemView.findViewById(R.id.city) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]
        with(holder) {
            city.text = item.name.toString()

            city.setOnClickListener {
                val bundle = bundleOf("id" to position.toString(),"item_id" to item.id.toString())
                itemView.findNavController()
                    .navigate(R.id.action_citiesFragment_to_weatherDetailsFragment, bundle)
            }
        }
    }

    fun updateData(list: MutableList<Item>) {
        mList = list
        notifyDataSetChanged()
    }

}