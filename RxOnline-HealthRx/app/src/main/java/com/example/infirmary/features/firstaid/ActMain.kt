package com.example.infirmary.features.firstaid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import com.example.infirmary.R

class ActMain : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_firstaid_act_main)

        recyclerView = findViewById(R.id.ItemsCon)
        submitButton = findViewById(R.id.Submit)

        val questions = mutableListOf(
            Quest(
                id = 1,
                text = "How do you feel?",
                choices = listOf("Pain", "Bleeding"),
                followUpQuestions = mapOf(
                    "Bleeding" to Quest(
                        id = 2,
                        text = "Where is the bleeding?",
                        choices = listOf("Head", "Upper Torso", "Lower Torso")
                    )
                    // Add more follow-up questions as needed
                )
            ),
            // Add more questions as needed
        )

        val questionAdapter = AdapterQuestions(questions)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = questionAdapter

        submitButton.setOnClickListener {
            val userAnswers = questionAdapter.getUserAnswers()
            // Handle the user answers, navigate to the next page, or show the result
        }
    }
}