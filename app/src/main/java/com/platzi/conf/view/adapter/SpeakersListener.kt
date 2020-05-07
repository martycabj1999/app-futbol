package com.platzi.conf.view.adapter

import com.platzi.conf.model.Speaker

interface SpeakersListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}