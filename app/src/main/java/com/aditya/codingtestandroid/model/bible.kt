package com.aditya.codingtestandroid.model


data class BibleResponse(
    val reference : String,
    val verses : List<Verse>
)
data class Verse(
    val book_id: String,
    val book_name: String,
    val chapter: Int,
    val text: String,
    val verse: Int
)