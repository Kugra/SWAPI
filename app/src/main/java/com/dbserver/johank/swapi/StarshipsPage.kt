package com.dbserver.johank.swapi

data class StarshipsPage (
        val count : Int,
        val next: String?,
        val previous: String?,
        val results: List<Starship>)