package br.com.faculdadeimpacta.usuarioroom.data.sources.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.faculdadeimpacta.usuarioroom.data.models.Usuario
import br.com.faculdadeimpacta.usuarioroom.data.sources.local.daos.UsuarioDAO
import kotlin.concurrent.Volatile

@Database(entities = [Usuario::class], version = 1)
abstract class RoomDB : RoomDatabase() {

    abstract fun getUsuarioDAO(): UsuarioDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(context: Context): RoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "roomDB"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}