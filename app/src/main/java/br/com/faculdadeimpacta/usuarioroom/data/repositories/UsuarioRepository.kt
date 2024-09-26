package br.com.faculdadeimpacta.usuarioroom.data.repositories

import br.com.faculdadeimpacta.usuarioroom.data.models.Usuario
import br.com.faculdadeimpacta.usuarioroom.data.sources.local.daos.UsuarioDAO

class UsuarioRepository(private val usuarioDAO: UsuarioDAO) {

    suspend fun inserir(usuario: Usuario) {
        usuarioDAO.inserir(usuario)
    }

    suspend fun atualizar(usuario: Usuario) {
        usuarioDAO.atualizar(usuario)
    }

    suspend fun deletar(usuario: Usuario) {
        usuarioDAO.deletar(usuario)
    }

    suspend fun getLista(): List<Usuario> = usuarioDAO.getLista()

    suspend fun getUsuarioPorId(usuarioId: Int) = usuarioDAO.getPorId(usuarioId)

}