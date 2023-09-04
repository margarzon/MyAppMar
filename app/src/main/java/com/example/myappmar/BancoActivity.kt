package com.example.myappmar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class BancoActivity : AppCompatActivity() {
    private var saldoActual = 1000.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.banco)

        val saldoTextView = findViewById<TextView>(R.id.saldoTextView)
        val montoDepositoEditText = findViewById<EditText>(R.id.montoDepositoEditText)
        val depositarButton = findViewById<Button>(R.id.depositarButton)
        val montoRetiroEditText = findViewById<EditText>(R.id.montoRetiroEditText)
        val retirarButton = findViewById<Button>(R.id.retirarButton)

        // Actualizar el saldo actual en el TextView
        actualizarSaldoTextView()

        depositarButton.setOnClickListener {
            val montoDeposito = montoDepositoEditText.text.toString().toDouble()
            saldoActual += montoDeposito
            actualizarSaldoTextView()
            montoDepositoEditText.text.clear()
        }

        retirarButton.setOnClickListener {
            val montoRetiro = montoRetiroEditText.text.toString().toDouble()
            if (montoRetiro <= saldoActual) {
                saldoActual -= montoRetiro
                actualizarSaldoTextView()
                montoRetiroEditText.text.clear()
            } else {
                // Mostrar mensaje de fondos insuficientes si se intenta retirar más de lo disponible
                showToast("Fondos insuficientes")
            }
        }
    }

    private fun actualizarSaldoTextView() {
        val saldoTexto = "Saldo actual: $saldoActual"
        val saldoTextView = findViewById<TextView>(R.id.saldoTextView)
        saldoTextView.text = saldoTexto
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
