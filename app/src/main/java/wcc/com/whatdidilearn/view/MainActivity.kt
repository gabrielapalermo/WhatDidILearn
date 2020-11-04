package wcc.com.whatdidilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import wcc.com.whatdidilearn.R
import wcc.com.whatdidilearn.data.DataBaseItems
import wcc.com.whatdidilearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.itemsRecycleView
        val adapter = LearnedItemsAdapter()
        recyclerView.adapter = adapter

        val learnedItemsList = DataBaseItems.getAll()
        adapter.data = learnedItemsList
    }
}