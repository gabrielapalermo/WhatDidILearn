package wcc.com.whatdidilearn.view

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_learned.view.*
import org.w3c.dom.Text
import wcc.com.whatdidilearn.R
import wcc.com.whatdidilearn.entity.ItemLearned

class LearnedItemsAdapter: RecyclerView.Adapter<LearnedItemsAdapter.LearnedItemViewHolder>() {
    var data = listOf<ItemLearned>()
    inner class LearnedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleItem: TextView = itemView.findViewById(R.id.itemTitle)
        val descriptionItem: TextView = itemView.findViewById(R.id.itemDescription)
        val levelItem: View = itemView.findViewById(R.id.itemLevel)

        fun bind(title: String, description: String, color: Int){
            titleItem.text = title
            descriptionItem.text = description
            levelItem.setBackgroundResource(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}