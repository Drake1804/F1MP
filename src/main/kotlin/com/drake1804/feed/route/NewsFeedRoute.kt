package com.drake1804.feed.route

import com.drake1804.feed.controller.FetchNewsFeedController
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.registerNewsFeedRoute() {
    routing {
        newsFeedRoute()
    }
}

fun Route.newsFeedRoute() {
    val controller by inject<FetchNewsFeedController>()
    route("/newsFeed") {
        get {
            call.respond(controller.execute())
        }
    }
}