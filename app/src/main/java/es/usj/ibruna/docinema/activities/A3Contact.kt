package es.usj.ibruna.docinema.activities

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import es.usj.ibruna.docinema.R

class A3Contact : AppCompatActivity(){

    private val requestCallPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if(granted) {
            val uri = Uri.parse("tel:651338996")
            val intent = Intent(Intent.ACTION_CALL, uri)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a3)

        val buttonBack = findViewById<Button>(R.id.btnBackContact)
        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }

        val buttonWeb= findViewById<Button>(R.id.btnWeb)
        buttonWeb.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.usj.es"))
            startActivity(browserIntent)
        }

        val buttonEmail= findViewById<Button>(R.id.btnEmail)
        buttonEmail.setOnClickListener {
            val sendIntent= Intent()
            sendIntent.action=Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Contact us:")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }

        val buttonCall= findViewById<Button>(R.id.btnCall)
        buttonCall.setOnClickListener {
            requestCallPermission.launch(Manifest.permission.CALL_PHONE)
        }
    }
}