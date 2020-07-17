package com.rs.home.repository

import com.rs.home.network.services.TMDBHomeService
import javax.inject.Inject

class TmdbRepository @Inject constructor(private val service: TMDBHomeService) {

    suspend fun getPopularMovies(page: Int = 1) = service.getPopularMovies(page = page)
}
