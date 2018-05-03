package com.dbserver.johank.swapi

/*FULL IMPLEMENTATION*/

data class Planet(
        val name: String,
        val rotation_period: String,
        val orbital_period: String,
        val diameter: String,
        val climate: String,
        val gravity: String,
        val terrain: String,
        val surface_water: String,
        val population: String,
        val residents: List<Character>?,
        val films: List<Film>)