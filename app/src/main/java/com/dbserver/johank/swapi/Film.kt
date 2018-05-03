package com.dbserver.johank.swapi

data class Film (
        val title: String,
        val episode_id: String,
        val opening_crawl: String,
        val director: String,
        val producer: String,
        val release_date: String,
        val characters: List<Character>)