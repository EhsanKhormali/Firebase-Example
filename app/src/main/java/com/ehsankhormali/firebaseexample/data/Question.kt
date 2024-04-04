package com.ehsankhormali.firebaseexample.data

data class Question
    (
    val id: String,
    val content: String,
    val picture:String="",
    val options:MutableList<Options>?=null
)