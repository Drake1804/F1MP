package com.drake1804.feed.model

@kotlinx.serialization.Serializable
class F1NewsModel(
    val title: String,
    val description: String,
    val image: String,
    val pubDate: String,
    val link: String
)