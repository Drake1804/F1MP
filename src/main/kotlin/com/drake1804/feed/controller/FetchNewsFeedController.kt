package com.drake1804.feed.controller

import com.drake1804.feed.model.News
import com.drake1804.feed.repo.IF1NewsRepository

class FetchNewsFeedController(private val f1NewsRepository: IF1NewsRepository) {

    suspend fun execute(): List<News> = f1NewsRepository.getFeed().channel.news
}