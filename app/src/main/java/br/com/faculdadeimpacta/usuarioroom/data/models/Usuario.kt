package br.com.faculdadeimpacta.usuarioroom.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var nome: String,
    var favorito: Boolean
)
