package wcc.com.whatdidilearn.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import wcc.com.whatdidilearn.entity.ItemLearned
import wcc.com.whatdidilearn.entity.Level

@Database(entities = [ItemLearned::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DataBaseItems: RoomDatabase() {

    abstract fun learnedItemDao(): LearnedItemDao

    companion object {
        // Singleton para evitar que multiplas instancias do banco de dados sejam abertas ao mesmo tempo
        @Volatile
        private var INSTANCE: DataBaseItems? = null


        fun getDatabase(context: Context): DataBaseItems {
            // se INSTANCE não é nulo, então retorna ela mesma,
            // se INSTANCE é nula, então cria uma instancia do banco
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBaseItems::class.java,
                    "learned_item_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

        fun getAll(): List<ItemLearned> {
            val itemOne = ItemLearned(
                "Kotlin - Null safety",
                "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código",
                Level.LOW
            )
            val itemTwo = ItemLearned(
                "Layout editor",
                "O Design Editor exibe o layout em vários dispositivos e versões do Android." +
                        "É possível criar e editar um layout usando apenas componentes visuais.",
                Level.MEDIUM
            )
            val itemThree = ItemLearned(
                "Git",
                "É um sistema de controle de versão distribuído. " +
                        "Com ele é possível rastrear mudanças no código-fonte durante o desenvolvimento de software.",
                Level.HIGH
            )
            val itemFour = ItemLearned(
                "GroupView",
                "É uma view especial que pode conter outras views (chamadas de filhos)." +
                        "É a classe base para layouts e contêineres de views.",
                Level.HIGH
            )
            val itemFive = ItemLearned(
                "View Binding",
                "ViewBinding é um recurso que facilita a programação de códigos que interagem com views.",
                Level.HIGH
            )

            return listOf(itemOne, itemTwo, itemThree, itemFour)
        }
    }
}