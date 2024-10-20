package com.mati_tech.intentkotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
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

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener{
            val explicitintent = Intent(this, MainActivity2::class.java)
            startActivity(explicitintent)
            finish()
//            use finish to dont come from first intent



        }


        //implicit intent to go to another app

        val btn2 = findViewById<Button>(R.id.button2)

        btn2.setOnClickListener{
            val url = "https://www.google.com"
            val implitcitintent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(implitcitintent)
            finish()
//            use finish to dont come from first intent
        }

    }
}