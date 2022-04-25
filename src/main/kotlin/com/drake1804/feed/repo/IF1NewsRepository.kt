package com.drake1804.feed.repo

import com.drake1804.feed.model.Rss


interface IF1NewsRepository {

    suspend fun getFeed(): Rss
}