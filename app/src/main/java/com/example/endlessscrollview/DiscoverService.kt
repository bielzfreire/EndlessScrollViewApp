package com.example.endlessscrollview

import retrofit2.Call
import retrofit2.http.GET

interface DiscoverService {

    @GET("discover/movie?api_key=5da5c7cec70cc62a19883de5799a21a9&sort_by=popularity.desc&page=1")
    fun discoverMovies(): Call<DiscoverMoviesResponse?>
}