package br.com.faculdadeimpacta.usuarioroom.data.sources.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.faculdadeimpacta.usuarioroom.data.models.Usuario

@Dao
interface UsuarioDAO {

    @Insert
    fun inserir(vararg usuario: Usuario)

    @Update
    fun atualizar(vararg usuario: Usuario)

    @Delete
    fun deletar(vararg usuario: Usuario)

    @Query("SELECT * FROM Usuario")
    fun getLista(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE id = :usuarioId")
    fun getPorId(usuarioId: Int): Usuario

}