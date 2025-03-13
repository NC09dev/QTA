package com.example.qta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos del layout
        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)

        // Función para obtener números ingresados y validar
        fun getNumbers(): Pair<Double, Double>? {
            val num1Text = etNumber1.text.toString()
            val num2Text = etNumber2.text.toString()

            if (num1Text.isEmpty() || num2Text.isEmpty()) {
                Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show()
                return null
            }

            return Pair(num1Text.toDouble(), num2Text.toDouble())
        }

        // Evento click para cada botón
        btnSumar.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                val result = it.first + it.second
                tvResult.text = "Resultado: $result"
            }
        }

        btnRestar.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                val result = it.first - it.second
                tvResult.text = "Resultado: $result"
            }
        }

        btnMultiplicar.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                val result = it.first * it.second
                tvResult.text = "Resultado: $result"
            }
        }

        btnDividir.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                if (it.second == 0.0) {
                    Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
                } else {
                    val result = it.first / it.second
                    tvResult.text = "Resultado: $result"
                }
            }
        }
    }
}
