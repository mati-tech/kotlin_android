package com.mati_tech.kotlinlistview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listview = findViewById <ListView>(R.id.listview)
        val listitems  = arrayOf(
            "Read  a Book",
            "Create a project",
            "Learn kotlin",
            "Go for a ride",
            "Attend a Seminar"
        )

        val listadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listitems)
        listview.adapter = listadapter

        listview.setOnItemClickListener{
            parent, view, position, id ->
            val selecteditem = parent.getItemAtPosition(position) as String
            Toast.makeText(this, "You have clicked on $selecteditem", Toast.LENGTH_LONG).show()
        }

    }
}