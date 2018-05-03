package com.dbserver.johank.swapi

data class Specie (
        val name: String,
        val classification: String,
        val designation: String,
        val average_height: String,
        val skin_colors: String,
        val hair_colors: String,
        val eye_colors: String,
        val average_lifespan: String,
        val homeworld: Planet,
        val language: String,
        val people: List<Character>)