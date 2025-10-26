package com.example.activitat04_androidstudio_primerapart

import android.content.Intent
import android.media.tv.TvView
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StartActivity : AppCompatActivity() {
    private var targetNumber = 0
    private lateinit var tvWelcome: TextView
    private lateinit var numerEdit: EditText
    private lateinit var btnGuess: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        initComponents()
        initListeners()
        initUI()
    }

    override fun onStart() {
        super.onStart()
        generateRandomNumber()
    }

    private fun initComponents() {
        tvWelcome = findViewById(R.id.tvWelcome)
        numerEdit = findViewById(R.id.numberEdit)
        btnGuess = findViewById(R.id.btnGuess)
        btnBack = findViewById(R.id.btnBack)
    }
    private fun initListeners() {
        btnGuess.setOnClickListener{
            checkGuess()
        }
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
    private fun checkGuess() {
        val inputNumber = numerEdit.text.toString()
        if (inputNumber.isEmpty()){
            numerEdit.error = "Has d'introduir un numero"
        } else {
            val numberGuess = inputNumber.toInt()
            val user = intent.getStringExtra("username")
            if (numberGuess == targetNumber){
                val intent = Intent(this, SuccesActivity::class.java)
                intent.putExtra("user",user)
                intent.putExtra("numberGuess", numberGuess)
                intent.putExtra("targetNumber", targetNumber)
                startActivity(intent)
            } else {
                val intent = Intent(this, ErrorActivity::class.java)
                intent.putExtra("user",user)
                intent.putExtra("numberGuess", numberGuess)
                intent.putExtra("targetNumber", targetNumber)
                startActivity(intent)
            }
        }
    }
    private fun initUI() {
        getUser()
    }

    private fun getUser() {
        val user = intent.getStringExtra("username")
        tvWelcome.text = "Benvingut/da, $user"
    }
    private fun generateRandomNumber() {
        targetNumber = (1..3).random()
    }
}


