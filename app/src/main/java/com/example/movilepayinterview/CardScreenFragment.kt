package com.example.movilepayinterview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.movilepayinterview.databinding.FragmentCardScreenBinding
import com.example.movilepayinterview.state.CardState
import com.example.movilepayinterview.viewmodel.CardViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardScreenFragment : Fragment() {

    private val viewModel by viewModel<CardViewModel>()

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
        viewModel.loadingState.observe(viewLifecycleOwner) { binding.progressBar.isVisible = it }
        viewModel.cardState.observe(viewLifecycleOwner) { handleCardState(it) }

        viewModel.fetchData()
    }

    private fun handleCardState(cardState: CardState){
        when(cardState) {
            is CardState.Empty -> {}
            is CardState.Loading -> {}
            is CardState.Loaded -> {
                with(binding) {
                    tvCardNumber.text = cardState.card.cardNumber
                    tvCardName.text = cardState.card.cardName
                    tvExpiration.text = "Expiration: ${cardState.card.expirationDate}"
                    tvLimit.text = "Limite disponivel: ${cardState.card.availableLimit}"
                    tvLimit2.text = "Limite Total: ${cardState.card.totalLimit}"
                }
            }
            is CardState.Error -> {
                Toast.makeText(requireContext(), cardState.errorMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}