package com.platzi.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.platzi.conf.model.Team
import com.platzi.conf.R
import com.platzi.conf.view.ui.fragments.TeamsFragment

class TeamsAdapter(val teamListener: TeamsFragment) : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    private var listTeams = ArrayList<Team>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false))

    override fun getItemCount() = listTeams.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team = listTeams[position] as Team

        holder.tvTeamName.text = team.name
        holder.tvTeamWork.text = team.estadio

        Glide.with(holder.itemView.context)
            .load(team.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivTeamImage)

        holder.itemView.setOnClickListener {
            teamListener.onTeamClicked(team, position)
        }

    }

    fun updateData(data: List<Team>) {
        listTeams.clear()
        listTeams.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTeamName = itemView.findViewById<TextView>(R.id.tvItemTeamName)
        val tvTeamWork = itemView.findViewById<TextView>(R.id.tvItemTeamWork)
        val ivTeamImage = itemView.findViewById<ImageView>(R.id.ivItemTeamImage)
    }
}