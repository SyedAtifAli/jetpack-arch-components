package com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturecomponents.R
import com.example.architecturecomponents.full_Mvvm_Retrofit_Room_Example.model.api.Result

class RvAdapter(private val list: List<Result>): RecyclerView.Adapter<RvAdapter.AdapterViewholder>() {


    class AdapterViewholder(view: View) : RecyclerView.ViewHolder(view){
        val text = view.findViewById<TextView>(R.id.name)
        val initials = view.findViewById<TextView>(R.id.initials)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem,parent,false)
        return AdapterViewholder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewholder, position: Int) {
        holder.text.text = list.get(position).content
        holder.initials.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return list.size
    }
}