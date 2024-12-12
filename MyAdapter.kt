import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourapp.Data
import com.example.yourapp.R

class MyAdapter(private val dataList: MutableList<Data>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
        val amountTextView: TextView = itemView.findViewById(R.id.amountTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.categoryTextView.text = data.category
        holder.contentTextView.text = data.content
        holder.amountTextView.text = if (data.amount > 0) "+${data.amount}" else "${data.amount}"
    }

    override fun getItemCount() = dataList.size

    fun setData(newData: List<Data>) {
        dataList.clear()
        dataList.addAll(newData)
        notifyDataSetChanged()
    }
}