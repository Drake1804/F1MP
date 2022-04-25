package com.drake1804.feed.controller

import com.drake1804.feed.model.F1NewsModel
import com.drake1804.feed.repo.IF1NewsRepository

class FetchNewsFeedController(private val f1NewsRepository: IF1NewsRepository) {
    suspend fun execute(): List<F1NewsModel> = f1NewsRepository.getFeed().channel.news.map {
        F1NewsModel(it.title.trim(), it.description.trim(), it.image.imageUrl, it.pubDate, it.link)
    }
}