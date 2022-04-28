package es.usj.ibruna.docinema.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import es.usj.ibruna.docinema.R

class A5ViewMovie : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a5)

        val buttonBack = findViewById<Button>(R.id.btnBackViewMovie)
        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val buttonEdit = findViewById<Button>(R.id.btnEditMovie)
        buttonEdit.setOnClickListener {
            val intent = Intent(this, A4EditMovie::class.java)
            startActivity(intent);
        }
    }
}