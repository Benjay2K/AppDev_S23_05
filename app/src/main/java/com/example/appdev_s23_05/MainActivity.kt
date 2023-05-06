package com.example.appdev_s23_05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var measurementActivityButton: Button
    private lateinit var converterActivityButton: Button
    private lateinit var listViewActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        measurementActivityButton = findViewById(R.id.measurementActivityButton)
        measurementActivityButton.setOnClickListener{
            val intent = Intent(this, MeasurementActivity::class.java)
            startActivity(intent)
        }

        converterActivityButton = findViewById(R.id.converterActivityButton)
        converterActivityButton.setOnClickListener{
            val intent = Intent(this, ConverterActivity::class.java)
            startActivity(intent)
        }

        listViewActivityButton = findViewById(R.id.listViewActivityButton)
        listViewActivityButton.setOnClickListener{
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }
    }
}