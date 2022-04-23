package com.drake1804

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.drake1804.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.1.0") {
        configureHTTP()
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
