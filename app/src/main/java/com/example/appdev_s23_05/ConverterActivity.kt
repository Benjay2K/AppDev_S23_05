package com.example.appdev_s23_05

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ConverterActivity : AppCompatActivity() {

    private lateinit var conversionSpinner: Spinner
    private lateinit var inputEditText: EditText
    private lateinit var outputEditText: EditText
    private lateinit var convertButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        conversionSpinner = findViewById(R.id.conversion_spinner)
        inputEditText = findViewById(R.id.inputEditText)
        outputEditText = findViewById(R.id.outputEditText)
        convertButton = findViewById(R.id.convertButton)

        val conversionModes = listOf("Meter to Inch", "Celsius to Fahrenheit", "Inch to Meter", "Fahrenheit to Celsius")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionModes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        conversionSpinner.adapter = adapter

        convertButton.setOnClickListener {
            val conversionMode = conversionSpinner.selectedItem.toString()
            val inputValue = inputEditText.text.toString().toDouble()
            val outputValue = convert(conversionMode, inputValue)
            outputEditText.setText(outputValue.toString())
        }
    }

    private fun convert(conversionMode: String, inputValue: Double): Double {
        return when (conversionMode) {
            "Meter to Inch" -> inputValue * 39.3701
            "Celsius to Fahrenheit" -> inputValue * 9 / 5 + 32
            "Inch to Meter" -> inputValue / 39.3701
            "Fahrenheit to Celsius" -> (inputValue - 32) * 5 / 9

            else -> 0.0
        }
    }
}