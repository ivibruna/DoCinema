package es.usj.ibruna.docinema.data

import java.io.Serializable

class Movie(idMovie: Long, title: String, year: Int):Serializable{

    var idMovie: Long
    var title: String
    var year: Int
    /*var description: String
    var runtime: Int
    var rating: Float
    var director: String
    var actorsList: ArrayList<Actor>
    var genresList: ArrayList<Genre>
    */

    init{
        this.idMovie = idMovie
        this.title = title
        this.year = year
        /*this.description = description
        this.runtime = runtime
        this.rating = rating
        this.director = director
        this.actorsList = actorsList
        this.genresList = genresList
         */
    }
}