package com.brunotiba.domain.model

/**
 * Entity representation of a location.
 *
 * @param name the location name
 * @param latitude the location latitude
 * @param longitude the location longitude
 */
data class Location(
    val name: String,
    val latitude: Double,
    val longitude: Double
)
