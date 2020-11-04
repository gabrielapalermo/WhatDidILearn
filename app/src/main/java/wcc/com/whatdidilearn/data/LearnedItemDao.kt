package wcc.com.whatdidilearn.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import wcc.com.whatdidilearn.entity.ItemLearned

@Dao
interface LearnedItemDao {
    @Query("SELECT * FROM Learned_item ORDER BY item_title ASC")
    fun getAll(): List<ItemLearned>

    @Insert
    fun insert(item: ItemLearned)
}