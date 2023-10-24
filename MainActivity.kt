package com.example.testapp4

import android.content.Intent
import android.content.Context.MODE_PRIVATE
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var savedName: String
    private lateinit var savedPass: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inputText
        editText = findViewById(R.id.edit_text)
        editText2 = findViewById(R.id.edit_text2)
        val button: Button = findViewById(R.id.button)
        checkBox = findViewById(R.id.checkbox)

        // 以前保存された名前とパスワードを取得
        val sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)
        savedName = sharedPreferences.getString("NAME", "").toString()
        savedPass = sharedPreferences.getString("PASS", "").toString()

        // 保存された名前とパスワードがない場合、新しい情報を入力し保存する
        if (savedName.isEmpty() || savedPass.isEmpty()) {
            button.setOnClickListener {
                val inputName = editText.text.toString()
                val inputPass = editText2.text.toString()

                if (inputName.isNotEmpty() && inputPass.isNotEmpty() && inputPass.length >= 8 && inputPass.length <= 12) {
                    // パスワードの条件を満たす場合、情報を保存
                    val editor = sharedPreferences.edit()
                    editor.putString("NAME", inputName)
                    editor.putString("PASS", inputPass)
                    editor.apply()

                    // Main2画面に遷移
                    val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("INPUT_NAME", inputName)
                    intent.putExtra("INPUT_PASS", inputPass)
                    startActivity(intent)
                } else {
                    // パスワードが条件を満たさない場合、Toastメッセージを表示
                    Toast.makeText(this, "パスワードは、8文字以上12文字以内で設定してください。", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            // 保存された名前とパスワードがある場合、通常のログイン処理を行う
            button.setOnClickListener {
                val inputName = editText.text.toString()
                val inputPass = editText2.text.toString()

                if (inputName.isNotEmpty() && inputPass.isNotEmpty() && inputPass.length >= 8 && inputPass.length <= 12) {
                    // パスワードが条件を満たす場合
                    if (inputName == savedName && inputPass == savedPass) {
                        // 一致した場合、次画面に遷移
                        val intent = Intent(this, MainActivity2::class.java)
                        intent.putExtra("INPUT_NAME", inputName)
                        intent.putExtra("INPUT_PASS", inputPass)
                        startActivity(intent)
                    } else {
                        // 一致しない場合、Toastメッセージを表示
                        Toast.makeText(this, "名前とパスワードが一致しません", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // パスワードが条件を満たさない場合、Toastメッセージを表示
                    Toast.makeText(this, "パスワードは、8文字以上12文字以内で設定してください。", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()

        // チェックボックスにチェックがある場合、SharedPreferencesから名前を読み取りEditTextにセットする
        val sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)

        // パスワードフィールドをクリアする
        editText2.text.clear()

        if (checkBox.isChecked) {
            val savedName = sharedPreferences.getString("NAME", "")
            editText.setText(savedName)
        } else {
            // チェックボックスがチェックされていない場合、EditTextをクリアする（必要に応じて）
            editText.text.clear()
        }

    }
}
