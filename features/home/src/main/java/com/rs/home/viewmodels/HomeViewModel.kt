package com.rs.home.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rs.core.network.helpers.NetworkHelper
import com.rs.core.network.response.Resource
import com.rs.home.network.response.Movie
import com.rs.home.network.response.base.MoviesResult
import com.rs.home.repository.TmdbRepository
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val tmdbRepository: TmdbRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _movies = MutableLiveData<Resource<MoviesResult<Movie>>>()
    val movies: LiveData<Resource<MoviesResult<Movie>>>
        get() = _movies

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            _movies.postValue(Resource.Loading())
            if (networkHelper.isNetworkConnected()) {
                tmdbRepository.getPopularMovies().let {
                    if (it.isSuccessful) {
                        _movies.postValue(Resource.Success(it.body() as MoviesResult<Movie>))
                    } else {
                        _movies.postValue(Resource.Error(it.message() ?: "Something went wrong"))
                    }
                }
            } else {
                _movies.postValue(Resource.Error("No internet connection"))
            }
        }
    }
}
