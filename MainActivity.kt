package com.example.testapp5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ボタンコード
        val button: Button = findViewById<Button>(R.id.button)
        button.setOnClickListener{

            //クリック時の処理
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)

        }

    }
}