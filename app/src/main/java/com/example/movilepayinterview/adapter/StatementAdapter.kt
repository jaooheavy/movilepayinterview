package com.example.movilepayinterview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movilepayinterview.databinding.StatementItemBinding
import com.example.movilepayinterview.model.StatementTransaction

class StatementAdapter(
    private val listStatement: List<StatementTransaction>
): RecyclerView.Adapter<StatementAdapter.StatementViewHolder>() {

    private lateinit var binding: StatementItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatementViewHolder {
        binding = StatementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatementViewHolder(binding.root)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: StatementViewHolder, position: Int) {
        val statement = listStatement[position]
        with(binding) {
            tvLabel.text = statement.label
            tvName.text = statement.description
            tvValue.text = statement.value
        }
    }

    override fun getItemCount() = listStatement.size

    class StatementViewHolder(v: View): RecyclerView.ViewHolder(v)
}