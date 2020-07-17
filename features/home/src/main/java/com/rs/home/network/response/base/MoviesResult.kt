package com.rs.home.network.response.base

import com.squareup.moshi.Json

data class MoviesResult<T>(
    val page: Int?,
    val results: List<T>,
    @Json(name = "total_results") val totalResults: Int?,
    @Json(name = "total_pages") val totalPages: Int?
)
