package com.example.myappmar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class HangmanView(context: Context) : View(context) {

    private val paint = Paint()
    private var incorrectGuesses = 0

    init {
        paint.color = Color.BLACK
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
    }

    fun setIncorrectGuesses(incorrectGuesses: Int) {
        this.incorrectGuesses = incorrectGuesses
        invalidate() // Solicita que se vuelva a dibujar la vista
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        when (incorrectGuesses) {
            1 -> drawHead(canvas)
            2 -> drawBody(canvas)
            3 -> drawLeftArm(canvas)
            4 -> drawRightArm(canvas)
            5 -> drawLeftLeg(canvas)
            6 -> drawRightLeg(canvas)
        }
    }

    private fun drawHead(canvas: Canvas) {
        canvas.drawCircle(200f, 200f, 50f, paint)
    }

    private fun drawBody(canvas: Canvas) {
        canvas.drawLine(200f, 250f, 200f, 400f, paint)
    }

    private fun drawLeftArm(canvas: Canvas) {
        canvas.drawLine(200f, 275f, 150f, 350f, paint)
    }

    private fun drawRightArm(canvas: Canvas) {
        canvas.drawLine(200f, 275f, 250f, 350f, paint)
    }

    private fun drawLeftLeg(canvas: Canvas) {
        canvas.drawLine(200f, 400f, 150f, 475f, paint)
    }

    private fun drawRightLeg(canvas: Canvas) {
        canvas.drawLine(200f, 400f, 250f, 475f, paint)
    }
}
