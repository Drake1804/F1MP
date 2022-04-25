package com.drake1804.feed.route

import com.drake1804.feed.controller.FetchNewsFeedController
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.registerNewsFeedRoute(controller: FetchNewsFeedController) {
    routing {
        newsFeedRoute(controller)
    }
}

fun Route.newsFeedRoute(controller: FetchNewsFeedController) {
    route("/newsFeed") {
        get {
            val res = controller.execute().toString()
            println(res)
            call.respondText(res)
        }
    }
}