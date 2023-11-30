package com.example.infirmary.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.infirmary.R

class BasicInfoAct : AppCompatActivity() {

    private lateinit var lastNameEditText: EditText
    private lateinit var firstNameEditText: EditText
    private lateinit var middleNameEditText: EditText
    private lateinit var birthdateEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var roleRadioGroup: RadioGroup
    private lateinit var nextButton: LinearLayout
    private lateinit var backButton: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_act_basicinfo)

        lastNameEditText = findViewById(R.id.LastName)
        firstNameEditText = findViewById(R.id.FirstName)
        middleNameEditText = findViewById(R.id.MiddleName)
        birthdateEditText = findViewById(R.id.Birthdate)
        genderRadioGroup = findViewById(R.id.groupchoices_gender)
        roleRadioGroup = findViewById(R.id.groupchoices_role)
        nextButton = findViewById(R.id.Nextpage)
        backButton = findViewById(R.id.Backpage)

        // Set up Back button listener
        backButton.setOnClickListener {
            finish()
        }

        // Set up Next button listener
        nextButton.setOnClickListener {
            val lastName = lastNameEditText.text.toString().trim()
            val firstName = firstNameEditText.text.toString().trim()
            val middleName = middleNameEditText.text.toString().trim()
            val birthdate = birthdateEditText.text.toString().trim()

            val email = intent.getStringExtra("email") ?: ""
            val phone = intent.getStringExtra("phone") ?: ""
            val idNumber = intent.getStringExtra("idnumber") ?: ""
            val password = intent.getStringExtra("password") ?: ""

            val gender = when (genderRadioGroup.checkedRadioButtonId) {
                R.id.Female -> "Female"
                R.id.Male -> "Male"
                else -> ""
            }

            val role = when (roleRadioGroup.checkedRadioButtonId) {
                R.id.Student -> "Student"
                R.id.Teacher -> "Teacher"
                R.id.Staff -> "Other"
                else -> ""
            }

            // Display error messages next to EditText widgets
            if (lastName.isEmpty()) {
                lastNameEditText.error = "Last Name is required"
            }

            if (firstName.isEmpty()) {
                firstNameEditText.error = "First Name is required"
            }

            if (middleName.isEmpty()) {
                middleNameEditText.error = "Middle Name is required"
            }

            if (gender.isEmpty()) {
                showErrorMessage(R.id.genderErrorTextView, "Error: Missing Gender")
            }

            if (role.isEmpty()) {
                showErrorMessage(R.id.roleErrorTextView, "Error: Missing Role")
                return@setOnClickListener
            }

            val intent = Intent(this, BgHistAct::class.java).apply {
                putExtra("lastname", lastName)
                putExtra("firstname", firstName)
                putExtra("middlename", middleName)
                putExtra("birthdate", birthdate)
                putExtra("gender", gender)
                putExtra("role", role)
                putExtra("email", email)
                putExtra("phone", phone)
                putExtra("idnumber", idNumber)
                putExtra("password", password)
            }

            startActivity(intent)
        }
    }

    private fun showErrorMessage(textViewId: Int, message: String) {
        val errorTextView = findViewById<TextView>(textViewId)
        errorTextView.text = message
        errorTextView.visibility = View.VISIBLE
    }
}