package com.example.testapp5

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button2: Button = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            finish()
        }
    }
}