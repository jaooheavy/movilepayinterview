package com.example.movilepayinterview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movilepayinterview.databinding.WidgetItemBinding
import com.example.movilepayinterview.model.WidgetItem

class WidgetAdapter(
    private val widgets: List<WidgetItem>,
    val onClickButton: (identify: String) -> Unit
): RecyclerView.Adapter<WidgetAdapter.StatementViewHolder>() {

    private lateinit var binding: WidgetItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatementViewHolder {
        binding = WidgetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatementViewHolder(binding.root)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: StatementViewHolder, position: Int) {
        val widgets = widgets[position]
        with(binding) {
            tvTop.text = widgets.content.title

            when(widgets.identifier){
                "HOME_CARD_WIDGET" -> {
                    tvDescription.text = widgets.content.cardNumber
                    tvValue.text = ""
                }
                "HOME_STATEMENT_WIDGET" -> {
                    tvDescription.text = widgets.content.balance.label
                    tvValue.text = widgets.content.balance.value
                }
            }

            button.text = widgets.content.button.text
            button.setOnClickListener {
                onClickButton(widgets.content.button.action.identifier)
            }
        }
    }

    override fun getItemCount() = widgets.size

    class StatementViewHolder(v: View): RecyclerView.ViewHolder(v)
}