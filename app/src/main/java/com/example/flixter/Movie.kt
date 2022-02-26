package com.example.flixter

import org.json.JSONArray

// Represent one movie object to display in UI
data class Movie(
    val movieID: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
) {
    val posterImageURL = "https://image.tmdb.org/t/p/w342/$posterPath"
    // A companion object allows us to call a method in a class without having
    // to declare an instance
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                        )
                )
            }
            return movies
        }
    }
}
