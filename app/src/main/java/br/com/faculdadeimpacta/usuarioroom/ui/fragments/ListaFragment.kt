package br.com.faculdadeimpacta.usuarioroom.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.faculdadeimpacta.usuarioroom.R
import br.com.faculdadeimpacta.usuarioroom.databinding.FragmentListaBinding

class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }
}