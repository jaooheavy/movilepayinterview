package com.example.movilepayinterview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movilepayinterview.adapter.WidgetAdapter
import com.example.movilepayinterview.core.MovileActions
import com.example.movilepayinterview.databinding.FragmentHomeScreenBinding
import com.example.movilepayinterview.model.WidgetItem
import com.example.movilepayinterview.state.WidgetState
import com.example.movilepayinterview.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeScreenFragment() : Fragment() {

    private val viewModel by viewModel<HomeViewModel>()
    private val actions by inject<MovileActions>{ parametersOf(findNavController()) }

    private var _binding: FragmentHomeScreenBinding? = null
    val binding get() = _binding!!

    private val widgets = mutableListOf<WidgetItem>()
    private val adapter by lazy {
        WidgetAdapter(widgets) { actions.orchestratorActionFromWidget(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadingState.observe(viewLifecycleOwner) { binding.progressBar.isVisible = it }
        viewModel.widgetState.observe(viewLifecycleOwner) { handleHomeState(it) }

        binding.rvHome.adapter = adapter

        viewModel.fetchData()
    }

    private fun handleHomeState(widgetState: WidgetState){
        when(widgetState) {
            is WidgetState.Empty -> {}
            is WidgetState.Loading -> {}
            is WidgetState.Loaded -> {
                with(binding) {
                    tvHeader.text =
                        widgetState.widgets.headerWidget?.content?.title ?: "Olá"

                    widgets.clear()
                    widgets.addAll(widgetState.widgets.recyclerWidget)
                    adapter.notifyDataSetChanged()
                }
            }
            is WidgetState.Error -> {
                Toast.makeText(requireContext(), widgetState.errorMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}