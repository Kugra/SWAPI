package com.dbserver.johank.swapi

data class FilmsPage (
        val count : Int,
        val next: String?,
        val previous: String?,
        val results: List<Film>)