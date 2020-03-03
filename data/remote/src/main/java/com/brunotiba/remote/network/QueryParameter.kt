package com.brunotiba.remote.network

/**
 * Representation of an HTTP request query parameter.
 *
 * @param query the name of the query parameter
 * @param value the value of the query parameter
 */
internal data class QueryParameter(
    val query: String,
    val value: String
)
