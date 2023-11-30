package com.example.infirmary.features.firstaid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infirmary.R

class AdapterQuestions(private val questions: MutableList<Quest>) :
    RecyclerView.Adapter<AdapterQuestions.QuestionViewHolder>() {

    private val userAnswers = mutableMapOf<Int, String>()

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionText: TextView = itemView.findViewById(R.id.questionText)
        val choicesRecyclerView: RecyclerView = itemView.findViewById(R.id.choicesRecyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.feature_firstaid_adapter_questions_item, parent, false)
        return QuestionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questions[position]

        holder.questionText.text = question.text

        val choicesAdapter = AdapterChoices(question.choices) { choice, isChecked ->
            userAnswers[question.id] = choice
            notifyDataSetChanged()

            question.followUpQuestions?.let { followUpQuestions ->
                followUpQuestions[choice]?.let { followUpQuestion ->
                    questions.add(position + 1, followUpQuestion)
                    notifyItemInserted(position + 1)
                }
            }
        }

        holder.choicesRecyclerView.adapter = choicesAdapter
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    fun getUserAnswers(): Map<Int, String> {
        return userAnswers
    }
}