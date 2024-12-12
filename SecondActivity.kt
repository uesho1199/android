import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.example.yourapp.Data // Dataクラスは別途作成

class SecondActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        recyclerView = findViewById(R.id.recyclerView)
        database = FirebaseDatabase.getInstance()
        databaseReference = database.getReference("data")

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(mutableListOf())
        recyclerView.adapter = adapter

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val dataList = mutableListOf<Data>()
                for (snapshot in snapshot.children) {
                    val data = snapshot.getValue(Data::class.java)
                    dataList.add(data!!)
                }
                adapter.setData(dataList)
            }

            override fun onCancelled(error: DatabaseError) {
                // エラー処理
            }
        })
    }
}