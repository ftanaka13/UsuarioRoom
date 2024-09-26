package br.com.faculdadeimpacta.usuarioroom.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import br.com.faculdadeimpacta.usuarioroom.R
import br.com.faculdadeimpacta.usuarioroom.databinding.FragmentCriacaoEdicaoBinding

class CriacaoEdicaoFragment : Fragment() {

    private var _binding: FragmentCriacaoEdicaoBinding? = null
    private val binding get() = _binding!!
    private val args: CriacaoEdicaoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCriacaoEdicaoBinding.inflate(inflater, container, false)
        return binding.root
    }
}