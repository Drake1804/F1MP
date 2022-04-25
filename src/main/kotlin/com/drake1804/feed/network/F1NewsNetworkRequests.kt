package com.drake1804.feed.network

import com.drake1804.feed.model.Rss
import io.ktor.client.*
import io.ktor.client.request.*
import org.simpleframework.xml.core.Persister


class F1NewsNetworkRequests(private val httpClient: HttpClient) {
    suspend fun getRssFeed(): Rss {
        val requestUrl = "https://www.f1news.ru/export/news.xml"
        val string: String = httpClient.get(requestUrl)
        val serializer = Persister()
        return serializer.read(Rss::class.java, string)
    }
}