package com.platzi.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platzi.conf.model.Torneo
import com.platzi.conf.R
import com.platzi.conf.view.ui.fragments.TorneoFragment
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TorneoAdapter(val torneoListener: TorneoFragment) : RecyclerView.Adapter<TorneoAdapter.ViewHolder>() {

    var listTorneo = ArrayList<Torneo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_torneo, parent, false))

    override fun getItemCount() = listTorneo.size

    override fun onBindViewHolder(holder: TorneoAdapter.ViewHolder, position: Int) {
        val torneo = listTorneo[position] as Torneo

        holder.tvTorneoName.text = torneo.name
        holder.tvTorneoPuntos.text = "Puntos: " + torneo.puntos

        Glide.with(holder.itemView.context)
            .load(torneo.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.tvTorneoImage)

        holder.itemView.setOnClickListener {
            torneoListener.onTorneoClicked(torneo, position)
        }

    }

    fun updateData(data: List<Torneo>) {
        listTorneo.clear()
        listTorneo.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTorneoName = itemView.findViewById<TextView>(R.id.tvItemTorneoName)
        val tvTorneoPuntos = itemView.findViewById<TextView>(R.id.tvItemTorneoPuntos)
        val tvTorneoImage = itemView.findViewById<ImageView>(R.id.ivItemTorneoImage)
    }

}