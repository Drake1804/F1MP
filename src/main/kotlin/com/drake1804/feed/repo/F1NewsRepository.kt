package com.drake1804.feed.repo

import com.drake1804.feed.model.Rss
import com.drake1804.feed.network.F1NewsNetworkRequests

class F1NewsRepository(private val f1NewsNetworkRequests: F1NewsNetworkRequests) : IF1NewsRepository {

    override suspend fun getFeed(): Rss {
        return f1NewsNetworkRequests.getRssFeed()
    }
}