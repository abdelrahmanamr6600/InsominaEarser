package com.marco.ensominaearser.model

import java.io.Serializable

data class Category(
    var name:String = "" ,
    var coverurl:String = "",
    var songs : ArrayList<String>  = ArrayList()

): Serializable
