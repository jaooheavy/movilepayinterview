package com.example.movilepayinterview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.movilepayinterview.adapter.StatementAdapter
import com.example.movilepayinterview.databinding.FragmentStatementScreenBinding
import com.example.movilepayinterview.model.StatementTransaction
import com.example.movilepayinterview.state.CardState
import com.example.movilepayinterview.state.StatementState
import com.example.movilepayinterview.viewmodel.StatementViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatementScreenFragment : Fragment() {

    private val viewModel by viewModel<StatementViewModel>()

    private var _binding: FragmentStatementScreenBinding? = null
    val binding get() = _binding!!

    private val listStatement = mutableListOf<StatementTransaction>()
    private val adapter by lazy { StatementAdapter(listStatement) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStatementScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadingState.observe(viewLifecycleOwner) { binding.progressBar.isVisible = it }
        viewModel.statementState.observe(viewLifecycleOwner) { handleStatementState(it) }

        binding.rvExtrato.adapter = adapter

        viewModel.fetchData()
    }

    private fun handleStatementState(statementState: StatementState){
        when(statementState) {
            is StatementState.Empty -> {}
            is StatementState.Loading -> {}
            is StatementState.Loaded -> {
                with(binding) {
                    tvLimit.text = statementState.statement.balance.label
                    tvLimit2.text = statementState.statement.balance.value
                    listStatement.clear()
                    listStatement.addAll(statementState.statement.transactions)
                    adapter.notifyDataSetChanged()
                }
            }
            is StatementState.Error -> {
                Toast.makeText(requireContext(), statementState.errorMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}