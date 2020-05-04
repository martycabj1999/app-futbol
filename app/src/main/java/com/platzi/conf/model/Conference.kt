package com.platzi.conf.model

import java.io.FileDescriptor
import java.io.Serializable
import java.util.*

class Conference: Serializable {

    lateinit var title: String
    lateinit var description: String
    lateinit var tag: String
    lateinit var datetime: Date
    lateinit var speaker: String

}