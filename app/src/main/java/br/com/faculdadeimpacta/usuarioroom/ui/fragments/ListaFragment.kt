package br.com.faculdadeimpacta.usuarioroom.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.faculdadeimpacta.usuarioroom.R
import br.com.faculdadeimpacta.usuarioroom.databinding.FragmentListaBinding
import br.com.faculdadeimpacta.usuarioroom.ui.activities.MainActivity
import br.com.faculdadeimpacta.usuarioroom.ui.adapters.UsuarioAdapter
import br.com.faculdadeimpacta.usuarioroom.ui.viewmodels.UsuarioViewModel
import br.com.faculdadeimpacta.usuarioroom.ui.viewmodels.UsuarioViewModelFactory

class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UsuarioViewModel by activityViewModels {
        UsuarioViewModelFactory((activity as MainActivity).usuarioRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel.listaUsuarios.observe(viewLifecycleOwner) { lista ->
            binding.recyclerView.adapter = UsuarioAdapter(lista) { usuario ->
                viewModel.atualizar(usuario)
            }
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        }

        viewModel.getLista()

        binding.floatingActionButton.setOnClickListener {
            val direction = ListaFragmentDirections.actionListaFragmentToCriacaoEdicaoFragment(0)
            findNavController().navigate(direction)
        }

    }
}