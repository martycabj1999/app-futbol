package com.platzi.conf.view.adapter

import com.platzi.conf.model.Torneo

interface SpeakersListener {
    fun onConferenceClicked(conference: Torneo, position: Int)
    fun onSpeakerClicked(speaker: Torneo, position: Int)
}