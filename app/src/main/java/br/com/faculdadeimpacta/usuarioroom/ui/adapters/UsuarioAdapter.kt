package br.com.faculdadeimpacta.usuarioroom.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import br.com.faculdadeimpacta.usuarioroom.data.models.Usuario
import br.com.faculdadeimpacta.usuarioroom.databinding.UsuarioItemBinding

class UsuarioAdapter(
    private val listaUsuario: List<Usuario>,
    private val acaoFavorito: (Usuario) -> Unit
) :
    RecyclerView.Adapter<UsuarioAdapter.UsuarioVH>() {

    inner class UsuarioVH(private val binding: UsuarioItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(usuario: Usuario) {
            binding.usuario = usuario
            binding.imageViewFavorito.isSelected = usuario.favorito
            binding.imageViewFavorito.setOnClickListener {
                usuario.favorito = !usuario.favorito
                acaoFavorito(usuario)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UsuarioItemBinding.inflate(layoutInflater, parent, false)
        return UsuarioVH(binding)
    }

    override fun onBindViewHolder(holder: UsuarioVH, position: Int) {
        holder.onBind(listaUsuario[position])
    }

    override fun getItemCount(): Int = listaUsuario.size
}