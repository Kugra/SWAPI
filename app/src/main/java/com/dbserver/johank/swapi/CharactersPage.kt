package com.dbserver.johank.swapi

data class CharactersPage (
                    val count : Int,
                    val next: String?,
                    val previous: String?,
                    val results: List<Character>)