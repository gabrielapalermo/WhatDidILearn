package wcc.com.whatdidilearn.data

import androidx.room.TypeConverter
import wcc.com.whatdidilearn.R
import wcc.com.whatdidilearn.entity.Level

class Converters {
    @TypeConverter
    fun levelToInt(level: Level): Int {
        return level.color
    }

    @TypeConverter
    fun intToLevel(color: Int): Level {
        return when(color) {
            R.color.purple_200 -> Level.HIGH
            R.color.purple_500 -> Level.MEDIUM
            else -> Level.LOW
        }
    }
}