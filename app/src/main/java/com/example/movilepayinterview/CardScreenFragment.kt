package com.example.movilepayinterview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.movilepayinterview.databinding.FragmentCardScreenBinding
import com.example.movilepayinterview.databinding.FragmentHomeScreenBinding
import com.example.movilepayinterview.state.WidgetState
import com.example.movilepayinterview.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardScreenFragment : Fragment() {
    private var _binding: FragmentCardScreenBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}