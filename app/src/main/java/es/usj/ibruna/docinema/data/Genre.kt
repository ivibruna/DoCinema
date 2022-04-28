package es.usj.ibruna.docinema.data

import java.io.Serializable

class Genre(idGenre: Long, name: String): Serializable {

    var idGenre: Long
    var name: String

    init{
        this.idGenre = idGenre
        this.name = name
    }
}