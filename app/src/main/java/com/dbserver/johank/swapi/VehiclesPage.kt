package com.dbserver.johank.swapi

data class VehiclesPage (
        val count : Int,
        val next: String?,
        val previous: String?,
        val results: List<Vehicle>)