package com.example.qta

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputValue: EditText
    private lateinit var btnCelsius: Button
    private lateinit var btnFahrenheit: Button
    private lateinit var btnKelvin: Button
    private lateinit var outputCelsius: TextView
    private lateinit var outputFahrenheit: TextView
    private lateinit var outputKelvin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Asegúrate de que el XML está creado

        // Referencias a los elementos de la UI
        inputValue = findViewById(R.id.inputValue)
        btnCelsius = findViewById(R.id.btnCelsius)
        btnFahrenheit = findViewById(R.id.btnFahrenheit)
        btnKelvin = findViewById(R.id.btnKelvin)

        // Asignar eventos a los botones
        btnCelsius.setOnClickListener { convertTemperature("Celsius") }
        btnFahrenheit.setOnClickListener { convertTemperature("Fahrenheit") }
        btnKelvin.setOnClickListener { convertTemperature("Kelvin") }
    }

    private fun convertTemperature(unit: String) {
        val value = inputValue.text.toString().toDoubleOrNull()

        if (value == null) {
            Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
            return
        }

        val celsius: Double = when (unit) {
            "Celsius" -> value
            "Fahrenheit" -> (value - 32) * 5 / 9
            "Kelvin" -> value - 273.15
            else -> value
        }

        // Convertimos a todas las unidades
        val fahrenheit = (celsius * 9 / 5) + 32
        val kelvin = celsius + 273.15

        // Mostramos los resultados en la UI con 3 decimales
        findViewById<TextView>(R.id.resultCelsius)?.text = "%.3f".format(celsius)
        findViewById<TextView>(R.id.resultFahrenheit)?.text = "%.3f".format(fahrenheit)
        findViewById<TextView>(R.id.resultKelvin)?.text = "%.3f".format(kelvin)
    }

}