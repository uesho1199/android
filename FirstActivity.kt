import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirstActivity : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        database = FirebaseDatabase.getInstance()
        databaseReference = database.getReference("data")

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val amountEditText = findViewById<EditText>(R.id.amountEditText)
        val categoryEditText = findViewById<EditText>(R.id.categoryEditText)
        val contentEditText = findViewById<EditText>(R.id.contentEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)

        // 初期状態で収入を選択済みとする（任意）
        radioGroup.check(R.id.incomeRadioButton)

        registerButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            val isIncome = selectedId == R.id.incomeRadioButton

            // 入力値を取得
            val amount = amountEditText.text.toString().toInt()
            val category = categoryEditText.text.toString()
            val content = contentEditText.text.toString()

            // Firebaseにデータをプッシュ
            val data = HashMap<String, Any>()
            data["amount"] = if (isIncome) amount else -amount
            data["category"] = category
            data["content"] = content
            databaseReference.push().setValue(data)
        }
    }
}