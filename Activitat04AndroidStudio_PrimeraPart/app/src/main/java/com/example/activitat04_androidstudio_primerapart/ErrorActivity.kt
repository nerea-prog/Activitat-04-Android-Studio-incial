package com.example.activitat04_androidstudio_primerapart

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ErrorActivity : AppCompatActivity() {
    private lateinit var btnBack: Button
    private lateinit var tvError: TextView
    private lateinit var tvUser: TextView
    private lateinit var tvTargetNumber: TextView
    private lateinit var tvInputNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)
        initComponents()
        initListeners()
        initUI()
    }



    private fun initComponents() {
        btnBack = findViewById(R.id.btnBack)
        tvError = findViewById(R.id.tvError)
        tvUser = findViewById(R.id.tvUser)
        tvTargetNumber = findViewById(R.id.tvTargetNumber)
        tvInputNumber = findViewById(R.id.tvInputNumber)
    }

    private fun initListeners() {
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI() {
        getUser()
        getTargetNumber()
        getInputNumber()
    }

    private fun getUser() {
        val user = intent.getStringExtra("user")
        tvUser.text = "Usuari: $user"
    }
    private fun getTargetNumber() {
        val targetNumber = intent.getIntExtra("targetNumber", -1)
        tvTargetNumber.text = "Numero a encertar: $targetNumber"
    }
    private fun getInputNumber() {
        val inputNumber = intent.getIntExtra("numberGuess", -1)
        tvInputNumber.text = "Numero introduit: $inputNumber"
    }
}