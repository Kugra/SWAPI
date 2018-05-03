package com.dbserver.johank.swapi

data class SpeciesPage (
        val count : Int,
        val next: String?,
        val previous: String?,
        val results: List<Specie>)