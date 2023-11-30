package com.example.infirmary.features.firstaid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.infirmary.R

class AdapterChoices(
    private val choices: List<String>,
    private val onChoiceSelected: (String, Boolean) -> Unit
) : RecyclerView.Adapter<AdapterChoices.ChoiceViewHolder>() {

    inner class ChoiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoiceViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.feature_firstaid_adapter_choices_item, parent, false)
        return ChoiceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChoiceViewHolder, position: Int) {
        val choice = choices[position]

        holder.checkBox.text = choice

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            onChoiceSelected.invoke(choice, isChecked)
        }
    }

    override fun getItemCount(): Int {
        return choices.size
    }
}