package com.platzi.conf.view.adapter

import com.platzi.conf.model.Team

interface TeamsListener {
    fun onTeamClicked(team: Team, position: Int)
}