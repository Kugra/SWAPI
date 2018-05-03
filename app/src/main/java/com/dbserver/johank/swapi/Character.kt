package com.dbserver.johank.swapi

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
//        val species: Specie,
//        val vehicles: List<>,
        val starships: List<Starship>?)