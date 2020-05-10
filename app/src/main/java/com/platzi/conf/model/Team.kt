package com.platzi.conf.model

import java.io.Serializable

class Team: Serializable {
    lateinit var name: String
    lateinit var estadio: String
    lateinit var entrenador: String
    lateinit var fundación: String
    lateinit var apodos: String
    lateinit var image: String
    lateinit var capacidad: String
}