package com.example.activitat04_androidstudio_segonapart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Accedim als elements xml utilitzant el xml
        val data = findViewById<TextView>(R.id.data)
        val nom = findViewById<EditText>(R.id.nom)
        val btninici = findViewById<Button>(R.id.btninici)

        // Mostra la data actual
        val dataActual = SimpleDateFormat("dd/mm/yyyy", Locale.getDefault()).format(Date())
        data.text = "$dataActual"

        // Boto per anar a la següent activity
        btninici.setOnClickListener {
            val nom = nom.text.toString() // Obtenim el nom escrit
            if (nom.isNotEmpty()){
                val intent = Intent(this, StartActivity::class.java)
                intent.putExtra("nomUsuari", nom)
                startActivity(intent)
            } else {
                nom.error = "Introdueix el teu nom"
            }
        }

    }
}