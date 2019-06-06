package com.example.endlessscrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/discover/movie?api_key=5da5c7cec70cc62a19883de5799a21a9&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
            .build()
    }
}
