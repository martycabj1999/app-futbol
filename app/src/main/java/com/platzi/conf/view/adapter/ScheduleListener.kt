package com.platzi.conf.view.adapter

import com.platzi.conf.model.Equipo

interface ScheduleListener {
    public val rlBaseSchedule: Any

    fun onConferenceClicked(conference: Equipo, position: Int)
    fun onScheduleClicked(conference: Equipo, position: Int)
}