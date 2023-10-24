package com.example.testapp4

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // 画像ファイル取得
        val backgroundImage: BitmapDrawable = resources.getDrawable(R.drawable.test1) as BitmapDrawable

        // アクティビティの背景に画像を設定
        window.decorView.background = backgroundImage

        var getName = findViewById<TextView>(R.id.get_text)
        var getPass = findViewById<TextView>(R.id.get_text2)
        val intentName = intent.getStringExtra("INPUT_NAME")
        val intentPass = intent.getStringExtra("INPUT_PASS")
        val deleteButton: Button = findViewById(R.id.delete_button)

        getName.text = intentName
        getPass.text = intentPass

        val button2: Button = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            finish()
        }

        deleteButton.setOnClickListener {
            // SharedPreferencesに保存された名前とパスワードを削除
            val sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            // Main画面に戻る
            finish()
        }
    }
}
