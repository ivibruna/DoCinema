package es.usj.ibruna.docinema.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import es.usj.ibruna.docinema.R
import es.usj.ibruna.docinema.data.Movie

class A6AddMovie : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a6)

        val buttonUpdate = findViewById<Button>(R.id.btnAddMovie2)
        buttonUpdate.setOnClickListener{
            var nameMovie = findViewById<EditText>(R.id.tvAddTitle)
            var yearMovie = findViewById<EditText>(R.id.tvAddYear)
            var newMovie = Movie (100, nameMovie.text.toString(),2020)
            val i = Intent(this, MainActivity::class.java).putExtra("serializableObject", newMovie)
            startActivity(intent);
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val buttonBack = findViewById<Button>(R.id.btnBackAddMovie)
        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}

private fun Intent.putExtra(s: String, newMovie: Movie) {

}
