package com.drake1804

import com.drake1804.feed.di.f1FeedModule
import com.drake1804.feed.route.registerNewsFeedRoute
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.drake1804.plugins.*
import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        sideMain()
    }.start(wait = true)
}

fun Application.sideMain() {
    configureHTTP()
    install(Koin) {
        modules(f1FeedModule)
    }
    install(ShutDownUrl.ApplicationCallFeature) {
        shutDownUrl = "/shutdown"
        exitCodeSupplier = { 0 }
    }
    registerNewsFeedRoute()
    configureSerialization()
}
