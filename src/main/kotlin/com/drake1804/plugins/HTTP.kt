package com.drake1804.plugins

import io.ktor.application.*
import io.ktor.features.*

fun Application.configureHTTP() {
    install(CORS) {
        anyHost()
    }
}
