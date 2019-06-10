package com.example.endlessscrollview

import java.util.*
import kotlin.collections.ArrayList

class Movie(
    val vote_count: Int? = null,
    val id: Int? = null,
    val video: Boolean = false,
    val vote_average: Double? = null,
    val title: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val genre_ids: ArrayList<Int>? = null,
    val backdrop_path: String? = null,
    val adult: Boolean = false,
    val overview: String? = null,
    val release_date: Date? = null
)