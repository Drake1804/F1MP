package com.drake1804.feed.model

import org.simpleframework.xml.*

@Root(name = "rss", strict = false)
data class Rss(
    @field:Element(name = "channel", required = false)
    var channel: Channel = Channel()
)

@Root(strict = false, name = "channel")
data class Channel(
    @field:ElementList(name = "item", inline = true)
    var news: ArrayList<News> = ArrayList()
)

@Root(strict = false, name = "item")
data class News(
    @field:Element(name = "title", required = false)
    @Path("rss/channel")
    var title: String = "",

    @field:Element(name = "description", required = false)
    @Path("rss/channel")
    var description: String = "",

    @field:Element(name = "link", required = false)
    @Path("rss/channel")
    var link: String = "",

    @field:Element(name = "pubDate", required = false)
    @Path("rss/channel")
    var pubDate: String = ""
)

