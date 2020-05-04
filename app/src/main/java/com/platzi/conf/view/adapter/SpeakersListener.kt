package com.platzi.conf.view.adapter

import com.platzi.conf.model.Speaker

interface SpeakersListener {
    fun onConferenceClicked(conference: Speaker, position: Int)
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}