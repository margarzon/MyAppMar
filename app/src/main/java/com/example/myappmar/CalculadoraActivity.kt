package com.example.myappmar


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class CalculadoraActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora)

        val numero1 = findViewById<EditText>(R.id.editTextNumero1)
        val numero2 = findViewById<EditText>(R.id.editTextNumero2)
        val textResultado = findViewById<TextView>(R.id.textViewResultado)
        val botonSumar = findViewById<Button>(R.id.buttonSumar)
        val botonRestar = findViewById<Button>(R.id.buttonRestar)
        val botonMultp = findViewById<Button>(R.id.buttonMultp)
        val botonDiv = findViewById<Button>(R.id.buttonDiv)
        val botonSeno = findViewById<Button>(R.id.buttonSeno)

        botonSumar.setOnClickListener {
            val recogerNum1 = numero1.text.toString().toDouble()
            val recogerNum2 = numero2.text.toString().toDouble()
            val resultado = recogerNum1 + recogerNum2
            textResultado.text = resultado.toString()
        }

        botonRestar.setOnClickListener {
            val recogerNum1 = numero1.text.toString().toDouble()
            val recogerNum2 = numero2.text.toString().toDouble()
            val resultado = recogerNum1 - recogerNum2
            textResultado.text = resultado.toString()
        }

        botonMultp.setOnClickListener {
            val recogerNum1 = numero1.text.toString().toDouble()
            val recogerNum2 = numero2.text.toString().toDouble()
            val resultado = recogerNum1 * recogerNum2
            textResultado.text = resultado.toString()
        }
        botonDiv.setOnClickListener {
            val recogerNum1 = numero1.text.toString().toDouble()
            val recogerNum2 = numero2.text.toString().toDouble()
            val resultado = recogerNum1 / recogerNum2
            textResultado.text = resultado.toString()
        }

        botonSeno.setOnClickListener {
            val recogerNum1 = numero1.text.toString().toDouble()
            val resultado = Math.sin(recogerNum1)
            textResultado.text = resultado.toString()
        }

    }
}