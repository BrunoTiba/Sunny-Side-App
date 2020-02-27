package com.brunotiba.repository.model

import java.util.Calendar

/**
 * Entity representation of Ultraviolet level.
 *
 * @param value the value of the ultraviolet
 * @param date the date of the ultraviolet measurement
 */
data class Uv(
    val value: Double,
    val date: Calendar
)
