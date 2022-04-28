package es.usj.ibruna.docinema.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.net.HttpURLConnection
import java.net.URL

object DataSource {
    //DEFINE URL OUR IP
    private val baseUrl = "http://192.168.0.15:8080"

    //MOVIES
    fun getMovieById(id: Int) : Movie {
        val url = URL("$baseUrl/movies/$id")
        val result = request(url)
        return Gson().fromJson(result, Movie::class.java)
    }

    fun getMovies(): List<Movie> {
        val url = URL("$baseUrl/movies")
        val result = request(url)
        val movieList: Type = object : TypeToken<ArrayList<Movie>>() {}.type
        return if(result != null) Gson().fromJson(result, movieList) else listOf()
    }

    //ACTORS
    fun getActorById(id: Int) : Actor {
        val url = URL("$baseUrl/actors/$id")
        val result = request(url)
        return Gson().fromJson(result, Actor::class.java)
    }

    fun getActors(): List<Actor> {
        val url = URL("$baseUrl/actors")
        val result = request(url)
        val actorList: Type = object : TypeToken<ArrayList<Actor>>() {}.type
        return if(result != null) Gson().fromJson(result, actorList) else listOf()
    }

    //GENRES
    fun getgGenreById(id: Int) : Genre {
        val url = URL("$baseUrl/genres/$id")
        val result = request(url)
        return Gson().fromJson(result, Genre::class.java)
    }
    fun getGenres(): List<Genre> {
        val url = URL("$baseUrl/genres")
        val result = request(url)
        val genresList: Type = object : TypeToken<ArrayList<Genre>>() {}.type
        return if(result != null) Gson().fromJson(result, genresList) else listOf()
    }


    //REQUEST AND READSTREAM
    private fun request(url: URL) : String? {
        lateinit var connection: HttpURLConnection
        lateinit var `in`: InputStream
        try {
            connection = url.openConnection() as HttpURLConnection
            `in` = connection.inputStream
            return readStream(`in`)
        } catch (e: Exception) {
            Log.e("EXCEPTION", e.message ?: "No message")
        } finally {
            connection.disconnect()
        }
        return null
    }

    private fun readStream(inputStream: InputStream): String {
        val br = BufferedReader(InputStreamReader(inputStream))
        val total = StringBuilder()
        while (true) {
            val line = br.readLine() ?: break
            total.append(line).append('\n')
        }
        return total.toString()
    }
}