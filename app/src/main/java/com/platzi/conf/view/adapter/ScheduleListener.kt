package com.platzi.conf.view.adapter

import com.platzi.conf.model.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}