package com.example.factorialapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberInput = findViewById<EditText>(R.id.numberInput)
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)
        val resetBtn = findViewById<Button>(R.id.resetBtn)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateBtn.setOnClickListener {

            val input = numberInput.text.toString()

            if (input.isEmpty()) {
                resultText.text = "Please enter a number"
                return@setOnClickListener
            }

            val number = input.toInt()

            if (number < 0) {
                resultText.text = "Enter positive number"
                return@setOnClickListener
            }

            var factorial = 1

            for (i in 1..number) {
                factorial *= i
            }

            resultText.text = "Factorial of $number is:\n$factorial"
        }

        resetBtn.setOnClickListener {
            numberInput.text.clear()
            resultText.text = "Result will appear here"
            numberInput.requestFocus()
        }
    }
}