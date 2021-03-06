package com.dbserver.johank.swapi

/*FULL IMPLEMENTATION*/

class Vehicle (
        val name: String,
        val model: String,
        val manufacturer: String,
        val cost_in_credits: String,
        val lenght: String,
        val max_atmosphering_speed: String,
        val crew: String,
        val passengers: String,
        val cargo_capacity: String,
        val consumables: String,
        val vehicle_class: String,
        val pilots: List<Character>,
        val films: List<Film>)