package com.example.myappmar

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val buttonCalculator = findViewById<Button>(R.id.buttonCalculator)

        buttonCalculator.setOnClickListener {
            // Abre la actividad de la calculadora
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }
        val buttonRetirarConsignar = findViewById<Button>(R.id.buttonRetirarConsignar)

        buttonRetirarConsignar.setOnClickListener {
            val intent = Intent(this, BancoActivity::class.java)
            startActivity(intent)
        }
    }
}
