package es.usj.ibruna.docinema.data

import java.io.Serializable

class Actor(idActor: Long, name: String): Serializable {

    var idActor: Long
    var name: String

    init{
        this.idActor = idActor
        this.name = name
    }
}