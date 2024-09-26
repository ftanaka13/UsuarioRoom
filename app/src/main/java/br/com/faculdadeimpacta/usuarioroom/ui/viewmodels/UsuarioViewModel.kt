package br.com.faculdadeimpacta.usuarioroom.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.faculdadeimpacta.usuarioroom.data.models.Usuario
import br.com.faculdadeimpacta.usuarioroom.data.repositories.UsuarioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel(private val usuarioRepository: UsuarioRepository) : ViewModel() {

    private val _listaUsuario = MutableLiveData<List<Usuario>>(listOf())
    val listaUsuarios: LiveData<List<Usuario>> = _listaUsuario

    private val _usuario = MutableLiveData<Usuario?>(null)
    val usuario: LiveData<Usuario?> = _usuario

    fun inserir(usuario: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            usuarioRepository.inserir(usuario)
            _listaUsuario.postValue(usuarioRepository.getLista())
        }
    }

    fun atualizar(usuario: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            usuarioRepository.atualizar(usuario)
            _usuario.postValue(null)
            _listaUsuario.postValue(usuarioRepository.getLista())
        }
    }

    fun deletar(usuario: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            usuarioRepository.deletar(usuario)
            _listaUsuario.postValue(usuarioRepository.getLista())
        }
    }

    fun getLista() {
        viewModelScope.launch(Dispatchers.IO) {
            _listaUsuario.postValue(usuarioRepository.getLista())
        }
    }

    fun getUsuario(usuarioId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _usuario.postValue(usuarioRepository.getUsuarioPorId(usuarioId))
        }
    }
}

class UsuarioViewModelFactory(private val usuarioRepository: UsuarioRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsuarioViewModel::class.java)) {
            return UsuarioViewModel(usuarioRepository) as T
        }
        throw IllegalArgumentException("Tipo errado")
    }
}