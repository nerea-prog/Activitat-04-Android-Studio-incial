package com.example.activitat04_androidstudio_primerapart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var tvDate: TextView
    private lateinit var usernameEdit: EditText
    private lateinit var btnHome: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()

    }

    private fun initComponents() {
        tvDate = findViewById(R.id.tvDate)
        usernameEdit = findViewById(R.id.usernameEdit)
        btnHome = findViewById(R.id.btnHome)
    }

    private fun initListeners() {
        btnHome.setOnClickListener {
            checkUser()
        }
    }

    private fun checkUser() {
        val input = usernameEdit.text.toString()
        if (!input.isEmpty()){
            val intent = Intent(this, StartActivity::class.java)
            intent.putExtra("username", input)
            startActivity(intent)
        } else {
            usernameEdit.error = "Debes escribir un nombre"
        }
    }

    private fun initUI() {
        getActualDate()
    }

    private fun getActualDate() {
        tvDate.text = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
    }
}