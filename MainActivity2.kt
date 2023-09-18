package com.example.testapp4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var getName = findViewById<TextView>(R.id.get_text)
        var getPass = findViewById<TextView>(R.id.get_text2)
        val intentName = intent.getStringExtra("INPUT_NAME")
        val intentPass = intent.getStringExtra("INPUT_PASS")

        getName.text = intentName
        getPass.text = intentPass

        val button2: Button = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            finish()
        }
    }
}