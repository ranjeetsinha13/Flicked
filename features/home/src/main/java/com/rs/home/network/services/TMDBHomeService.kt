package com.rs.home.network.services

import com.rs.home.network.response.Movie
import com.rs.home.network.response.base.MoviesResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBHomeService {

    @GET("/3/movie/popular/")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Response<MoviesResult<Movie>>
}
