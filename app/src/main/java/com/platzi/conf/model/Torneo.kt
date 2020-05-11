package com.platzi.conf.model

import java.io.Serializable
import java.util.*

class Torneo: Serializable {
    var image = ""
    lateinit var name: String
    lateinit var puntos: String
    lateinit var promedio: String
    lateinit var website: String
}