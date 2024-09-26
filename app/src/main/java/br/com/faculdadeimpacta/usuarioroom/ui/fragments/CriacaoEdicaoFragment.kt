package br.com.faculdadeimpacta.usuarioroom.ui.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.faculdadeimpacta.usuarioroom.R
import br.com.faculdadeimpacta.usuarioroom.data.models.Usuario
import br.com.faculdadeimpacta.usuarioroom.databinding.FragmentCriacaoEdicaoBinding
import br.com.faculdadeimpacta.usuarioroom.ui.activities.MainActivity
import br.com.faculdadeimpacta.usuarioroom.ui.viewmodels.UsuarioViewModel
import br.com.faculdadeimpacta.usuarioroom.ui.viewmodels.UsuarioViewModelFactory

class CriacaoEdicaoFragment : Fragment() {

    private var _binding: FragmentCriacaoEdicaoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UsuarioViewModel by activityViewModels {
        UsuarioViewModelFactory((activity as MainActivity).usuarioRepository)
    }
    private val args: CriacaoEdicaoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCriacaoEdicaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val usuarioId = args.userId
        if (usuarioId == 0) {
            binding.buttonSalvar.setOnClickListener {
                val novoUsuario = Usuario(nome = binding.editTextText.text.toString().trim())
                viewModel.inserir(novoUsuario)
                findNavController().popBackStack()
            }
        } else {
            viewModel.usuario.observe(viewLifecycleOwner) { usuario ->
                binding.editTextText.setText(usuario?.nome)
                binding.buttonSalvar.setOnClickListener {
                    usuario?.nome = binding.editTextText.text.toString().trim()
                    viewModel.atualizar(usuario!!)
                    findNavController().popBackStack()
                }
            }
            viewModel.getUsuario(usuarioId)


        }
    }
}