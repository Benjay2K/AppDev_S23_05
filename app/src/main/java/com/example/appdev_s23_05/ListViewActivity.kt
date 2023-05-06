package com.example.appdev_s23_05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listView = findViewById<ListView>(R.id.list_view)

        // Create an ArrayList of items to display in the ListView
        val items = arrayListOf("Apple", "Banana", "Orange", "Pear", "Pineapple", "Mango", "Grape", "Watermelon", "Cherry", "Kiwi", "Peach", "Strawberry", "Raspberry", "Blueberry", "Blackberry", "Melon", "Coconut", "Lemon", "Lime", "Grapefruit")

        // Create an ArrayAdapter to display the items in the ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        // Set the adapter for the ListView
        listView.adapter = adapter

        // Set an item click listener on the ListView
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "Selected item: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}