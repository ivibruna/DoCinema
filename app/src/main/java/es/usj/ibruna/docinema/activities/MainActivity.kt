package es.usj.ibruna.docinema.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.usj.ibruna.docinema.R
import es.usj.ibruna.docinema.adapters.MovieAdapter
import es.usj.ibruna.docinema.data.DataSource
import es.usj.ibruna.docinema.data.Movie
import es.usj.ibruna.docinema.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val ui : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val scope: CoroutineScope by lazy {
        CoroutineScope(Dispatchers.IO)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //Tema base de la aplicacion
        setTheme(R.style.Theme_DoCinema)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creo el contenedor donde almacenamos la peliculas que recogemos
        lateinit var movieList: ArrayList<Movie>
        val llm = LinearLayoutManager(this)
        scope.launch {
            //Recogemos la informacion de la API
            movieList = DataSource.getMovies() as ArrayList<Movie>
            runOnUiThread {
                var recyclerView: RecyclerView = findViewById(R.id.rvMovieList)
                var adapter = MovieAdapter(movieList)
                recyclerView.layoutManager =llm
                recyclerView.adapter = adapter
            }
        }

        val buttonContact = findViewById<Button>(R.id.btnContact)
        buttonContact.setOnClickListener {
            val intent = Intent(this, A3Contact::class.java)
            startActivity(intent);
        }

        val buttonAdd = findViewById<Button>(R.id.btnAddMovie)
        buttonAdd.setOnClickListener {
            val intent = Intent(this, A6AddMovie::class.java)
            startActivity(intent);
        }

    }
}


