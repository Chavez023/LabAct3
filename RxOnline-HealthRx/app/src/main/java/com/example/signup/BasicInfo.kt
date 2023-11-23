package com.example.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.infirmary.R

class BasicInfo : AppCompatActivity() {

    private lateinit var lastnameEditText: EditText
    private lateinit var firstnameEditText: EditText
    private lateinit var middlenameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_basicinfo)

        lastnameEditText = findViewById(R.id.LastName)
        firstnameEditText = findViewById(R.id.FirstName)
        middlenameEditText = findViewById(R.id.MiddleName)

        val backButton: View = findViewById(R.id.Backpage)
        backButton.setOnClickListener {
            finish() // Finish the activity to go back
        }

        val nextButton: LinearLayout = findViewById(R.id.Nextpage)
        nextButton.setOnClickListener {
            val email = lastnameEditText.text.toString()
            val phone = firstnameEditText.text.toString()
            val idNumber = middlenameEditText.text.toString()

            if (phone.isBlank() && email.isBlank()) {
                firstnameEditText.error = "First Name is required"
                lastnameEditText.error = "Last Name is required"
                return@setOnClickListener
            } else {
                val intent = Intent(this, BgHistory::class.java)
                intent.putExtra("emailLogininfo", email)
                intent.putExtra("phoneLogininfo", phone)
                intent.putExtra("idnumberLogininfo", idNumber)
                startActivity(intent) // Start the next activity
            }
        }
    }
}
