package com.example.endlessscrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.gson.Gson
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        requestMovies()
    }

    private fun requestMovies() {
        val discoverMoviesService = retrofit.create(DiscoverService::class.java)
        val request = discoverMoviesService.discoverMovies()

        request.enqueue(object : Callback<DiscoverMoviesResponse?> {
            override fun onFailure(call: Call<DiscoverMoviesResponse?>, t: Throwable) {
                Toast.makeText(this@MainActivity, getString(R.string.no_movies_found), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DiscoverMoviesResponse?>, response: Response<DiscoverMoviesResponse?>) {
                response.body().let { body ->
                    movies_list.adapter = body?.results?.let { result ->
                        MoviesListAdapter(this@MainActivity, result)
                    }
                    movies_list.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        })
    }

    companion object {
        private const val base_url = "https://api.themoviedb.org/3/"
    }
}