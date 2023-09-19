package com.example.testapp4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inputText
        var editName = findViewById<EditText>(R.id.edit_text)
        var editPass = findViewById<EditText>(R.id.edit_text2)
        var inputName = editText.editableName
        var inputPass = editText2.editablePass

        //ボタンコード
        val button: Button = findViewById<Button>(R.id.button)
        button.setOnClickListener{

            if(editText.text != null) {
                //クリック時の処理
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("INPUT_NAME", inputName.toString())
                intent.putExtra("INPUT_PASS", inputPass.toString())

                if(inputName.toString().length != 0 && inputPass.toString().length != 0){
                    startActivity(intent)
                }
            }
        }

        //チェックボックス
        val checkBox: CheckBox = findViewById(R.id.checkbox);

    }
}
