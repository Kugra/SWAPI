package com.dbserver.johank.swapi

/*FULL IMPLEMENTATION*/

data class Character (
        val name: String,
        val height: String,
        val mass: String,
        val hair_color: String,
        val skin_color: String,
        val eye_color: String,
        val birth_year: String,
        val gender: String,
        val homeworld: Planet,
        val films: List<Film>,
        val species: List<Specie>?,
        val vehicles: List<Vehicle>?,
        val starships: List<Starship>?)