package com.dbserver.johank.swapi

data class PlanetsPage (
        val count : Int,
        val next: String?,
        val previous: String?,
        val results: List<Planet>)