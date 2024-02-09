package com.example.movie.models

import android.widget.Button
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Date

data class Model(var kinoNomi:String, var date: String = SimpleDateFormat("dd.MM.yyyy").format(Date())
 ,var aktiyor:String, var aboutMovie:String ):Serializable