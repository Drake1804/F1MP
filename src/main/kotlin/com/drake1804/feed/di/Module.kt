package com.drake1804.feed.di

import com.drake1804.feed.controller.FetchNewsFeedController
import com.drake1804.feed.network.F1NewsNetworkRequests
import com.drake1804.feed.repo.F1NewsRepository
import com.drake1804.feed.repo.IF1NewsRepository
import com.drake1804.plugins.XMLSerializer
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.http.*
import org.koin.dsl.module

val f1FeedModule = module {
    single { createHttpClient() }
    single { F1NewsNetworkRequests(get()) }
    single<IF1NewsRepository> { F1NewsRepository(get()) }
    single { FetchNewsFeedController(get()) }
}

private fun createHttpClient(): HttpClient {
    return HttpClient(CIO) {
        install(JsonFeature) {
            serializer = XMLSerializer()
            accept(ContentType.Application.Xml)
        }
    }
}