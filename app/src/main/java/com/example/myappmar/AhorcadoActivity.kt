package com.example.myappmar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AhorcadoActivity: AppCompatActivity() {

    private val words = arrayOf("ANDROID", "JAVA", "KOTLIN", "XML", "STUDIO")
    private lateinit var currentWord: String
    private lateinit var guessedWord: StringBuilder
    private var remainingAttempts = 6
    private var currentAttempt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ahorcado)

        val hangmanImageView = findViewById<ImageView>(R.id.hangmanImageView)
        val wordTextView = findViewById<TextView>(R.id.wordTextView)
        val letterEditText = findViewById<EditText>(R.id.letterEditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val guessButton = findViewById<Button>(R.id.guessButton)

        // Escoge una palabra aleatoria del array
        currentWord = words.random().toUpperCase()

        // Inicializa la palabra adivinada con guiones bajos
        guessedWord = StringBuilder("_".repeat(currentWord.length))

        wordTextView.text = guessedWord.toString()

        guessButton.setOnClickListener {
            val letter = letterEditText.text.toString().toUpperCase()

            if (letter.length != 1 || !letter[0].isLetter()) {
                resultTextView.text = "Ingresa una letra válida."
                return@setOnClickListener
            }

            if (currentWord.contains(letter)) {
                // La letra está en la palabra
                for (i in currentWord.indices) {
                    if (currentWord[i] == letter[0]) {
                        guessedWord[i] = letter[0]
                    }
                }
                wordTextView.text = guessedWord.toString()

                if (!guessedWord.contains("_")) {
                    resultTextView.text = "¡Felicidades! Adivinaste la palabra: '$currentWord'."
                    guessButton.isEnabled = false
                }
            } else {
                // La letra no está en la palabra
                remainingAttempts--
                currentAttempt++
                updateHangmanImage(hangmanImageView, currentAttempt)
                if (remainingAttempts == 0) {
                    resultTextView.text = "¡Perdiste! La palabra era '$currentWord'."
                    guessButton.isEnabled = false
                } else {
                    resultTextView.text = "Letra incorrecta. Te quedan $remainingAttempts intentos."
                }
            }

            letterEditText.text.clear()
        }
    }

    private fun updateHangmanImage(hangmanImageView: ImageView, attempt: Int) {
        // Ajustamos el índice para que coincida con el rango de imágenes que tienes (1 al 6)
        val imageName = "img${attempt + 1}"
        val imageId = resources.getIdentifier(imageName, "drawable", packageName)
        hangmanImageView.setImageResource(imageId)
    }
}
